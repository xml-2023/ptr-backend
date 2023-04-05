package com.kncm.usecase.user;

import com.kncm.dto.Response;
import com.kncm.model.Flight;
import com.kncm.model.Ticket;
import com.kncm.model.User;
import com.kncm.store.FlightStore;
import com.kncm.store.UserStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.user.FindBookedTicketsByUserIdValidator;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class FindBookedTicketsByUserIdUseCase {
    private final FlightStore flightStore;
    private final UserStore userStore;
    private final FindBookedTicketsByUserIdValidator validator;

    public Response findTickets(Long userId) {
        Collection<Flight> flights = flightStore.findAll();
        User user = userStore.find(userId);
        ValidationReport report = validator.validate(userId);
        List<Flight> bookedFlights = new ArrayList<Flight>();
        if (report.isValid()) {
            findBookedTickets(userId, flights, bookedFlights);
            return new Response(report, bookedFlights);
        }

        return new Response(report, user.getId());
    }

    private static void findBookedTickets(Long userId, Collection<Flight> flights, Collection<Flight> bookedFlights) {
        for (Flight flight : flights) {
            for (Ticket t : flight.getTickets()) {
                if (t.getOwner() != null) {
                    if (t.getOwner().getId() == userId && t.isBooked() == true) {
                        bookedFlights.add(flight);
                        break;
                    }
                }
            }
        }
    }
}
