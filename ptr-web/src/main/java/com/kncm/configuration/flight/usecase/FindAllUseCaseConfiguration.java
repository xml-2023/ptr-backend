package com.kncm.configuration.flight.usecase;

import com.kncm.store.FlightStore;
import com.kncm.usecase.flight.FindAllUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllUseCaseConfiguration {
    @Bean
    public FindAllUseCase findAllUseCase(FlightStore flightStore) {
        return new FindAllUseCase(flightStore);
    }
}
