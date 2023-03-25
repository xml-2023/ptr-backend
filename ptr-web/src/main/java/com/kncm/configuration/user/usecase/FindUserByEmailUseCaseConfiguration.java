package com.kncm.configuration.user.usecase;

import com.kncm.store.UserStore;
import com.kncm.usecase.user.FindUserByEmailUseCase;
import com.kncm.validator.user.FindUserByEmailValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByEmailUseCaseConfiguration {
    @Bean
    public FindUserByEmailUseCase findUserByEmailUseCase(UserStore store, FindUserByEmailValidator validator) {
        return new FindUserByEmailUseCase(store, validator);
    }
}
