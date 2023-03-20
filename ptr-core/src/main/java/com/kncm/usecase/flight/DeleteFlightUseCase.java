package com.kncm.usecase.flight;

import com.kncm.model.Flight;
import com.kncm.model.Ticket;
import com.kncm.store.FlightStore;
import com.kncm.store.TicketStore;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class DeleteFlightUseCase {
    private final FlightStore flightStore;
    private final TicketStore ticketStore;

    public void delete(Flight flight){
        for(Ticket ticket : flight.getTickets()){
            ticketStore.delete(ticket);
        }
        flightStore.delete(flight);
    }
}
