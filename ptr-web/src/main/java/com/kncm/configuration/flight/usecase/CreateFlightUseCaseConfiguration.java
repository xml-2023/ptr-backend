package com.kncm.configuration.flight.usecase;

import com.kncm.store.FlightStore;
import com.kncm.usecase.flight.CreateFlightUseCase;
import com.kncm.validator.flight.CreateFlightValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateFlightUseCaseConfiguration {
    @Bean
    public CreateFlightUseCase createFlightUseCase(FlightStore store, CreateFlightValidator validator) {
        return new CreateFlightUseCase(store, validator);
    }
}