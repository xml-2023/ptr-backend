package com.kncm.configuration.role.usecase;

import com.kncm.store.RoleStore;
import com.kncm.usecase.role.CreateRoleUseCase;
import com.kncm.validator.role.CreateRoleValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateRoleUseCaseConfiguration {
    @Bean
    public CreateRoleUseCase createRoleUseCase(RoleStore store, CreateRoleValidator validator) {
        return new CreateRoleUseCase(store, validator);
    }
}
