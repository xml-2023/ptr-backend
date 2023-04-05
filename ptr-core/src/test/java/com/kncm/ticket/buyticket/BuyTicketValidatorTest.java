package com.kncm.ticket.buyticket;

import com.kncm.model.Ticket;
import com.kncm.model.User;
import com.kncm.role.RoleBuilder;
import com.kncm.store.RoleStore;
import com.kncm.store.UserStore;
import com.kncm.ticket.TicketBuilder;
import com.kncm.user.UserBuilder;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.ticket.BuyTicketValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class BuyTicketValidatorTest {
    private User user;
    private Ticket ticket;
    private UserBuilder userBuilder;
    private RoleBuilder roleBuilder;
    private TicketBuilder ticketBuilder;
    private BuyTicketValidator buyTicketValidator;
    @Mock
    private UserStore store;
    @Mock
    private RoleStore roleStore;

    @BeforeEach
    void setUp() {
        roleBuilder = new RoleBuilder();
        userBuilder = new UserBuilder(roleBuilder);
        user = userBuilder.initializeUser();
        ticketBuilder = new TicketBuilder();
        ticket = ticketBuilder.initializeTicket();
        buyTicketValidator = new BuyTicketValidator();
    }

    @Test
    void validate_False() {

        ValidationReport report = buyTicketValidator.validate(null, null);

        assertFalse(report.isValid());
    }

    @Test
    void validate_True() {
        ValidationReport report = buyTicketValidator.validate(ticket, user);

        assertTrue(report.isValid());
    }
}
