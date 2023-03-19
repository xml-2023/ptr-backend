package com.kncm.configuration.role;

import com.kncm.converter.RoleConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConverterConfiguration {
    @Bean
    public RoleConverter roleConverter() {
        return new RoleConverter();
    }
}
