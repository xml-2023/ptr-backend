package com.kncm.configuration.user.usecase;

import com.kncm.store.FlightStore;
import com.kncm.store.UserStore;
import com.kncm.usecase.user.FindBookedTicketsByUserIdUseCase;
import com.kncm.validator.user.FindBookedTicketsByUserIdValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindBookedTicketsByUserIdUseCaseConfiguration {
    @Bean
    public FindBookedTicketsByUserIdUseCase findBookedTicketsByUserIdUseCase(FlightStore flightStore, UserStore userStore, FindBookedTicketsByUserIdValidator validator) {
        return new FindBookedTicketsByUserIdUseCase(flightStore, userStore, validator);
    }
}
