package com.kncm.configuration.user.usecase;

import com.kncm.store.RoleStore;
import com.kncm.store.UserStore;
import com.kncm.usecase.user.RegisterUserUseCase;
import com.kncm.validator.user.CreateUserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterUserUseCaseConfiguration {
    @Bean
    public RegisterUserUseCase registerUserUseCase(UserStore store, RoleStore roleStore, CreateUserValidator validator) {
        return new RegisterUserUseCase(store, roleStore, validator);
    }
}
