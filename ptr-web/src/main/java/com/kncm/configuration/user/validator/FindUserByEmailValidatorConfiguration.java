package com.kncm.configuration.user.validator;

import com.kncm.store.UserStore;
import com.kncm.validator.user.FindUserByEmailValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByEmailValidatorConfiguration {
    @Bean
    public FindUserByEmailValidator findUserByEmailValidator(UserStore store) {
        return new FindUserByEmailValidator(store);
    }
}
