package com.kncm.validator.ticket;

import com.kncm.constant.TicketConstant;
import com.kncm.constant.UserConstant;
import com.kncm.model.Ticket;
import com.kncm.model.User;
import com.kncm.validator.ValidationReport;

import java.util.HashMap;

public class BuyTicketValidator {
    public ValidationReport validate(Ticket ticket, User user) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        if (ticket == null) {
            report.setValid(false);
            report.addMessage(TicketConstant.TICKET, "ticket is null");
        }
        if (user == null) {
            report.setValid(false);
            report.addMessage(UserConstant.USER, "user is null");
        }
        if (ticket != null && user != null) {
            if (ticket.isBooked()) {
                report.setValid(false);
                report.addMessage(TicketConstant.TICKET, "ticket is already booked");
            }
        }

        return report;
    }
}
