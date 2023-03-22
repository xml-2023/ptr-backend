package com.kncm.usecase.flight;

import com.kncm.dto.Response;
import com.kncm.model.Flight;
import com.kncm.model.Ticket;
import com.kncm.store.FlightStore;
import com.kncm.store.TicketStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.flight.FindFlightValidator;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class DeleteFlightUseCase {
    private final FlightStore flightStore;
    private final TicketStore ticketStore;
    private final FindFlightValidator validator;

    public Response delete(Long id) {
        Response response;
        ValidationReport report = validator.validate(id);
        if (report.isValid()) {
            Flight flight = flightStore.find(id);
            response = new Response(report, flight);
            for (Ticket ticket : flight.getTickets()) {
                ticketStore.delete(ticket);
            }
            flightStore.delete(flight);
        } else {
            response = new Response(report, id);
        }
        return response;
    }
}
