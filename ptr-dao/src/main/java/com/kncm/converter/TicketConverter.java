package com.kncm.converter;

import com.kncm.entity.TicketEntity;
import com.kncm.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketConverter implements GenericConverter<Ticket, TicketEntity> {
    @Override
    public Ticket toModel(TicketEntity ticketEntity) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketEntity.getId());
        ticket.setBooked(ticketEntity.isBooked());
        ticket.setSeat(ticketEntity.getSeat());
        ticket.setPrice(ticketEntity.getPrice());
        ticket.setOwner(ticketEntity.getOwner());
        return ticket;
    }

    @Override
    public List<Ticket> toModel(List<TicketEntity> ticketEntities) {
        List<Ticket> tickets = new ArrayList<>();
        for (TicketEntity ticketEntity : ticketEntities) {
            Ticket ticket = new Ticket();
            ticket.setId(ticketEntity.getId());
            ticket.setBooked(ticketEntity.isBooked());
            ticket.setSeat(ticketEntity.getSeat());
            ticket.setPrice(ticketEntity.getPrice());
            ticket.setOwner(ticketEntity.getOwner());
            tickets.add(ticket);
        }
        return tickets;
    }

    @Override
    public TicketEntity toEntity(Ticket ticket) {
        TicketEntity entity = new TicketEntity();
        entity.setId(ticket.getId());
        entity.setBooked(ticket.isBooked());
        entity.setSeat(ticket.getSeat());
        entity.setPrice(ticket.getPrice());
        entity.setOwner(ticket.getOwner());
        return entity;
    }

    @Override
    public List<TicketEntity> toEntity(List<Ticket> tickets) {
        List<TicketEntity> entities = new ArrayList<>();
        for (Ticket ticket : tickets) {
            TicketEntity entity = new TicketEntity();
            entity.setId(ticket.getId());
            entity.setBooked(ticket.isBooked());
            entity.setSeat(ticket.getSeat());
            entity.setPrice(ticket.getPrice());
            entity.setOwner(ticket.getOwner());
            entities.add(entity);
        }
        return entities;
    }
}
