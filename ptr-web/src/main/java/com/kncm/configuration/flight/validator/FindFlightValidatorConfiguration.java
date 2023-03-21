package com.kncm.configuration.flight.validator;

import com.kncm.store.FlightStore;
import com.kncm.validator.flight.FindFlightValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindFlightValidatorConfiguration {
    @Bean
    public FindFlightValidator findFlightValidator(FlightStore store) {
        return new FindFlightValidator(store);
    }
}
