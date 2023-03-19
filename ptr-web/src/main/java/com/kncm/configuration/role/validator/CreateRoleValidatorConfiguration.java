package com.kncm.configuration.role.validator;

import com.kncm.store.RoleStore;
import com.kncm.validator.role.CreateRoleValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateRoleValidatorConfiguration {
    @Bean
    public CreateRoleValidator createRoleValidator(RoleStore store) {
        return new CreateRoleValidator(store);
    }
}
