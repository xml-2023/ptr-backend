package com.kncm.validator.ticket;

import com.kncm.constant.TicketConstant;
import com.kncm.model.Ticket;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.Validator;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class CreateTicketValidator implements Validator<Ticket> {
    @Override
    public ValidationReport validate(Ticket ticket) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        if (ticket == null) {
            report.setValid(false);
            report.addMessage(TicketConstant.TICKET, "ticket is null");
        } else {
            if (StringUtils.isBlank(ticket.getSeat())) {
                report.setValid(false);
                report.addMessage(TicketConstant.SEAT, "seat is blank");
            }
            if (ticket.getPrice() < 0) {
                report.setValid(false);
                report.addMessage(TicketConstant.PRICE, "price cannot be lower than 0");
            }
        }

        return report;
    }
}
