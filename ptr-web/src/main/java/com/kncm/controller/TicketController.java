package com.kncm.controller;

import com.kncm.dto.Response;
import com.kncm.dto.ticket.TicketDTO;
import com.kncm.usecase.ticket.BuyTicketUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final BuyTicketUseCase buyTicketUseCase;

    @PutMapping("/buy")
    public Response buy(@RequestBody TicketDTO dto) {
        return buyTicketUseCase.buy(dto.getUserId(), dto.getTicketId(), dto.getFlightId());
    }
}
