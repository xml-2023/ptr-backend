package com.kncm.configuration.flight.usecase;

import com.kncm.store.FlightStore;
import com.kncm.store.TicketStore;
import com.kncm.usecase.flight.DeleteFlightUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteFlightUseCaseConfiguration {
    @Bean
    public DeleteFlightUseCase deleteFlightUseCase(FlightStore flightStore, TicketStore ticketStore) {
        return new DeleteFlightUseCase(flightStore, ticketStore);
    }
}
