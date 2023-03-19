package com.kncm.configuration.user.usecase;

import com.kncm.store.UserStore;
import com.kncm.usecase.user.CreateUserUseCase;
import com.kncm.validator.user.CreateUserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUserUseCaseConfiguration {
    @Bean
    public CreateUserUseCase createUserUseCase(UserStore store, CreateUserValidator validator) {
        return new CreateUserUseCase(store, validator);
    }
}
