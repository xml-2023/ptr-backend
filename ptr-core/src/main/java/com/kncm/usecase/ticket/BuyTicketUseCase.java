package com.kncm.usecase.ticket;

import com.kncm.dto.Response;
import com.kncm.model.Ticket;
import com.kncm.model.User;
import com.kncm.store.TicketStore;
import com.kncm.store.UserStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.ticket.BuyTicketValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuyTicketUseCase {
    private final UserStore userStore;
    private final TicketStore ticketStore;
    private final BuyTicketValidator validator;

    public Response buy(Long userId, Long ticketId) {
        User user = userStore.find(userId);
        Ticket ticket = ticketStore.find(ticketId);
        ValidationReport report;
        synchronized (ticket) {
            report = validator.validate(ticket, user);
            if (report.isValid()) {
                ticket.setBooked(true);
                ticket.setOwner(user);
                ticketStore.update(ticket);
            }
        }

        return new Response(report, ticket.getId());
    }
}
