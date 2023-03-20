package com.kncm.store;

import com.kncm.model.Ticket;

public interface TicketStore {
    Ticket save(Ticket ticket);

    Ticket find(Long id);

    boolean exists(String email);
}