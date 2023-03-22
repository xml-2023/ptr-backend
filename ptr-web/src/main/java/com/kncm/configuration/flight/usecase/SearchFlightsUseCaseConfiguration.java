package com.kncm.configuration.flight.usecase;

import com.kncm.store.FlightStore;
import com.kncm.usecase.flight.SearchFlightsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchFlightsUseCaseConfiguration {
    @Bean
    public SearchFlightsUseCase searchFlightsUseCase(FlightStore flightStore) {
        return new SearchFlightsUseCase(flightStore);
    }
}
