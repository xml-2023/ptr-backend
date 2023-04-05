package com.kncm.usecase.ticket;

import com.kncm.dto.Response;
import com.kncm.model.Flight;
import com.kncm.model.Ticket;
import com.kncm.model.User;
import com.kncm.store.FlightStore;
import com.kncm.store.TicketStore;
import com.kncm.store.UserStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.ticket.BuyTicketValidator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BuyTicketUseCase {
    private final UserStore userStore;
    private final TicketStore ticketStore;
    private final FlightStore flightStore;
    private final BuyTicketValidator validator;

    public Response buy(Long userId, Long ticketId, Long flightId) {
        User user = userStore.find(userId);
        Ticket ticket = ticketStore.find(ticketId);
        ValidationReport report;
        synchronized (ticket) {
            report = validator.validate(ticket, user);
            if (report.isValid()) {
                ticket.setBooked(true);
                ticket.setOwner(user);
                ticketStore.update(ticket);
            }
        }
        updateFlightByTicketId(ticketId, flightId, user, ticket);

        return new Response(report, ticket.getId());
    }

    private void updateFlightByTicketId(Long ticketId, Long flightId, User user, Ticket ticket) {
        Flight flight = flightStore.find(flightId);
        List<Ticket> tickets = flight.getTickets();
        for (Ticket t : tickets) {
            if (t.getId() == ticketId) {
                flight.setNumberOfPassengers(flight.getNumberOfPassengers() + 1);
                t.setBooked(true);
                t.setOwner(user);
                flightStore.save(flight);
                break;
            }
        }
    }
}
