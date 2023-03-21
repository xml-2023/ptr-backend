package com.kncm.ticket;

import com.kncm.constant.Constant;
import com.kncm.model.Ticket;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.ticket.CreateTicketValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class CreateTicketValidatorTest {
    private Ticket ticket;
    private TicketBuilder ticketBuilder;
    private CreateTicketValidator validator;

    @BeforeEach
    void setUp() {
        ticketBuilder = new TicketBuilder();
        ticket = ticketBuilder.initializeTicket();
        validator = new CreateTicketValidator();
    }

    @Test
    void validate_TicketSeatIsEmpty_False() {
        ticket.setSeat(Constant.EMPTY_STRING);

        ValidationReport report = validator.validate(ticket);

        assertFalse(report.isValid());
    }

    @Test
    void validate_TicketPriceLowerThanZero_False() {
        ticket.setPrice(-10);

        ValidationReport report = validator.validate(ticket);

        assertFalse(report.isValid());
    }
}
