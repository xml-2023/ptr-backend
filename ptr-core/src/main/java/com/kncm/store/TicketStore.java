package com.kncm.store;

import com.kncm.model.Ticket;

import java.util.Collection;

public interface TicketStore {

    Collection<Ticket> findAll();

    Ticket save(Ticket ticket);

    Ticket find(Long id);

    void delete(Ticket ticket);

    boolean exists(Long ticketId);

    Ticket update(Ticket ticket);

}
