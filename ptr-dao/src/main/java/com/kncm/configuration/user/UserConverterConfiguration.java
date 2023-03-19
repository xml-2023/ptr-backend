package com.kncm.configuration.user;

import com.kncm.converter.RoleConverter;
import com.kncm.converter.UserConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConverterConfiguration {
    @Bean
    public UserConverter userConverter(RoleConverter roleConverter) {
        return new UserConverter(roleConverter);
    }
}
