package com.kncm.store;

import com.kncm.converter.TicketConverter;
import com.kncm.model.Ticket;
import com.kncm.repository.TicketRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketStoreImpl implements TicketStore{
    private final TicketRepository repository;
    private final TicketConverter converter;

    @Override
    public Ticket save(Ticket ticket) { return converter.toModel(repository.save(converter.toEntity(ticket))); }

    @Override
    public Ticket find(Long id) { return converter.toModel(repository.findOne(id)); }

    @Override
    public void delete(Ticket ticket) { repository.delete(converter.toEntity(ticket)); }
}
