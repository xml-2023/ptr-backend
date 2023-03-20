package com.kncm.configuration.flight.validator;

import com.kncm.validator.flight.CreateFlightValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateFlightValidatorConfiguration {
    @Bean
    public CreateFlightValidator createFlightValidator() {
        return new CreateFlightValidator();
    }
}
