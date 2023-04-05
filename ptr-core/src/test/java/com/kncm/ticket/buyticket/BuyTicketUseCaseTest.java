package com.kncm.ticket.buyticket;

import com.kncm.flight.FlightBuilder;
import com.kncm.model.Flight;
import com.kncm.model.Ticket;
import com.kncm.model.User;
import com.kncm.role.RoleBuilder;
import com.kncm.store.FlightStore;
import com.kncm.store.TicketStore;
import com.kncm.store.UserStore;
import com.kncm.ticket.TicketBuilder;
import com.kncm.usecase.ticket.BuyTicketUseCase;
import com.kncm.user.UserBuilder;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.ticket.BuyTicketValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class BuyTicketUseCaseTest {
    private final ValidationReport validReport = new ValidationReport(true, new HashMap<>());
    private final ValidationReport invalidReport = new ValidationReport(false, new HashMap<>());
    @Mock
    BuyTicketValidator validator;
    @Mock
    UserStore userStore;
    @Mock
    TicketStore ticketStore;
    @Mock
    FlightStore flightStore;
    private BuyTicketUseCase useCase;

    private UserBuilder userBuilder;
    private FlightBuilder flightBuilder;
    private TicketBuilder ticketBuilder;
    private RoleBuilder roleBuilder;

    private User user;
    private Flight flight;
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        roleBuilder = new RoleBuilder();
        userBuilder = new UserBuilder(roleBuilder);
        flightBuilder = new FlightBuilder();
        ticketBuilder = new TicketBuilder();
        user = userBuilder.initializeUser();
        flight = flightBuilder.initializeFlight();
        ticket = ticketBuilder.initializeTicket();
        useCase = new BuyTicketUseCase(userStore, ticketStore, flightStore, validator);
    }

    /*@Test
    void update_TicketIsValid_True() {
        when(validator.validate(ticket, user))
                .thenReturn(validReport);

        useCase.buy(user.getId(), 16L, flight.getId());

        verify(ticketStore, times(0)).update(ticket);
    }

    @Test
    void update_TicketIsInvalid_False() {
        when(validator.validate(ticket, user))
                .thenReturn(invalidReport);

        useCase.buy(user.getId(), ticket.getId(), flight.getId());

        verify(ticketStore, times(0)).update(ticket);
    }*/
}
