package com.kncm.repository;

import com.kncm.entity.TicketEntity;

public interface TicketRepository extends EntityRepository<TicketEntity> {
    boolean existsById(Long ticketId);
}
