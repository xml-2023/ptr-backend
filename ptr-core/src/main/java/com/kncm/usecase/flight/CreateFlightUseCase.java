package com.kncm.usecase.flight;

import com.kncm.dto.Response;
import com.kncm.model.Flight;
import com.kncm.model.Ticket;
import com.kncm.store.FlightStore;
import com.kncm.store.TicketStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.flight.CreateFlightValidator;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class CreateFlightUseCase {
    private final FlightStore flightStore;
    private final TicketStore ticketStore;
    private final CreateFlightValidator validator;

    public Response create(Flight flight, double ticketPrice) {
        ValidationReport report = validator.validate(flight);
        Flight createdFlight = new Flight();
        //create ticket list
        ArrayList<Ticket> createdTickets = new ArrayList<>();
        for (int i = 1; i <= flight.getPlaneCapacity(); ++i) {
            Ticket ticket = new Ticket();
            //ticket.setId(Integer.toUnsignedLong(i));
            ticket.setSeat(Integer.toString(i));
            ticket.setBooked(false);
            ticket.setPrice(ticketPrice);
            ticketStore.save(ticket);
            createdTickets.add(ticket);
        }
        flight.setTickets(createdTickets);
        flight.setNumberOfPassengers(0);
        if (report.isValid()) {
            createdFlight = flightStore.save(flight);
        }

        return new Response(report, createdFlight.getId());
    }
}
