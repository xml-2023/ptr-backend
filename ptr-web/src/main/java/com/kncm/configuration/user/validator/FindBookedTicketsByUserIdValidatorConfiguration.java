package com.kncm.configuration.user.validator;

import com.kncm.store.UserStore;
import com.kncm.validator.user.FindBookedTicketsByUserIdValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindBookedTicketsByUserIdValidatorConfiguration {
    @Bean
    public FindBookedTicketsByUserIdValidator findBookedTicketsByUserIdValidator(UserStore userStore) {
        return new FindBookedTicketsByUserIdValidator(userStore);
    }
}
