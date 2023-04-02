package com.kncm.configuration.ticket.validator;

import com.kncm.validator.ticket.BuyTicketValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuyTicketValidatorConfiguration {
    @Bean
    public BuyTicketValidator buyTicketValidator() {
        return new BuyTicketValidator();
    }
}
