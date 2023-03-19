package com.kncm.configuration.user;

import com.kncm.converter.UserConverter;
import com.kncm.repository.UserRepository;
import com.kncm.store.UserStore;
import com.kncm.store.UserStoreImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserStoreConfiguration {
    @Bean
    public UserStore userStore(UserRepository repository, UserConverter converter) {
        return new UserStoreImpl(repository, converter);
    }
}
