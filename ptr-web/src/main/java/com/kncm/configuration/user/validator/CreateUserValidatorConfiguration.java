package com.kncm.configuration.user.validator;

import com.kncm.store.RoleStore;
import com.kncm.store.UserStore;
import com.kncm.validator.user.CreateUserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUserValidatorConfiguration {
    @Bean
    public CreateUserValidator createUserValidator(UserStore userStore, RoleStore roleStore) {
        return new CreateUserValidator(userStore, roleStore);
    }
}
