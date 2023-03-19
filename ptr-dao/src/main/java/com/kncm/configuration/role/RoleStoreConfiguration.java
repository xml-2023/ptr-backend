package com.kncm.configuration.role;

import com.kncm.converter.RoleConverter;
import com.kncm.repository.RoleRepository;
import com.kncm.store.RoleStore;
import com.kncm.store.RoleStoreImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleStoreConfiguration {
    @Bean
    public RoleStore roleStore(RoleRepository repository, RoleConverter converter) {
        return new RoleStoreImpl(repository, converter);
    }
}
