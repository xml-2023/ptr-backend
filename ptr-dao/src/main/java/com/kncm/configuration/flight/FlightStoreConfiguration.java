package com.kncm.configuration.flight;

import com.kncm.converter.FlightConverter;
import com.kncm.repository.FlightRepository;
import com.kncm.store.FlightStore;
import com.kncm.store.FlightStoreImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlightStoreConfiguration {
    @Bean
    public FlightStore flightStore(FlightRepository repository, FlightConverter converter) {
        return new FlightStoreImpl(repository, converter);
    }
}
