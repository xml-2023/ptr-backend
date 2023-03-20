package com.kncm.configuration.flight.usecase;

import com.kncm.store.FlightStore;
import com.kncm.usecase.flight.FindFlightUseCase;
import com.kncm.validator.flight.FindFlightValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindFlightUseCaseConfiguration {
    @Bean
    public FindFlightUseCase findFlightUseCase(FlightStore flightStore, FindFlightValidator validator) {
        return new FindFlightUseCase(flightStore, validator);
    }
}
