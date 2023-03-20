package com.kncm.configuration.flight;

import com.kncm.converter.FlightConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlightConverterConfiguration {
    @Bean
    public FlightConverter flightConverter() {
        return new FlightConverter();
    }
}
