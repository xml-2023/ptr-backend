package com.kncm.ticket;

import com.kncm.constant.TestConstant;
import com.kncm.model.Ticket;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketBuilder {

    public Ticket initializeTicket() {
        Ticket ticket = new Ticket();
        ticket.setId(TestConstant.TEST_ID);
        ticket.setPrice(50);
        ticket.setSeat("2");
        ticket.setBooked(false);
        return ticket;
    }
}
