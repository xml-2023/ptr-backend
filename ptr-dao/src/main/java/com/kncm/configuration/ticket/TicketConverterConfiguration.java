package com.kncm.configuration.ticket;

import com.kncm.converter.TicketConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketConverterConfiguration {
    @Bean
    public TicketConverter ticketConverter() {
        return new TicketConverter();
    }
}
