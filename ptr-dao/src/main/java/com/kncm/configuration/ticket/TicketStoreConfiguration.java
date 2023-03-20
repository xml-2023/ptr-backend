package com.kncm.configuration.ticket;

import com.kncm.converter.TicketConverter;
import com.kncm.repository.TicketRepository;
import com.kncm.store.TicketStore;
import com.kncm.store.TicketStoreImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketStoreConfiguration {
    @Bean
    public TicketStore ticketStore(TicketRepository repository, TicketConverter converter) {
        return new TicketStoreImpl(repository, converter);
    }
}
