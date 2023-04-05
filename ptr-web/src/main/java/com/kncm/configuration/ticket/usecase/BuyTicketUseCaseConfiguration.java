package com.kncm.configuration.ticket.usecase;

import com.kncm.store.FlightStore;
import com.kncm.store.TicketStore;
import com.kncm.store.UserStore;
import com.kncm.usecase.ticket.BuyTicketUseCase;
import com.kncm.validator.ticket.BuyTicketValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuyTicketUseCaseConfiguration {
    @Bean
    public BuyTicketUseCase buyTicketUseCase(UserStore userStore, TicketStore ticketStore, FlightStore flightStore, BuyTicketValidator validator) {
        return new BuyTicketUseCase(userStore, ticketStore, flightStore, validator);
    }
}
