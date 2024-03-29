package com.kncm.store;

import com.kncm.SequenceGenerator;
import com.kncm.converter.TicketConverter;
import com.kncm.entity.TicketEntity;
import com.kncm.model.Ticket;
import com.kncm.repository.TicketRepository;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class TicketStoreImpl implements TicketStore {
    private final TicketRepository repository;
    private final TicketConverter converter;
    private final SequenceGenerator generator;

    @Override
    public Collection<Ticket> findAll() {
        return converter.toModel(repository.findAll());
    }

    @Override
    public Ticket save(Ticket ticket) {
        ticket.setId(generator.getSequenceNumber(TicketEntity.SEQUENCE_NAME));
        return converter.toModel(repository.save(converter.toEntity(ticket)));
    }

    @Override
    public Ticket find(Long id) {
        return converter.toModel(repository.findOne(id));
    }

    @Override
    public void delete(Ticket ticket) {
        repository.deleteById(ticket.getId());
    }

    @Override
    public boolean exists(Long ticketId) {
        return repository.existsById(ticketId);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return converter.toModel(repository.save(converter.toEntity(ticket)));
    }


}
