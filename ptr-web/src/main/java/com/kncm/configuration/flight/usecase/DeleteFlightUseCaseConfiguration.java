package com.kncm.configuration.flight.usecase;

import com.kncm.store.FlightStore;
import com.kncm.store.TicketStore;
import com.kncm.usecase.flight.DeleteFlightUseCase;
import com.kncm.validator.flight.FindFlightValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteFlightUseCaseConfiguration {
    @Bean
    public DeleteFlightUseCase deleteFlightUseCase(FlightStore flightStore, TicketStore ticketStore, FindFlightValidator validator) {
        return new DeleteFlightUseCase(flightStore, ticketStore, validator);
    }
}
