package com.kncm.controller;

import com.kncm.dto.flight.FlightDTO;
import com.kncm.dto.Response;
import com.kncm.model.Flight;
import com.kncm.usecase.flight.CreateFlightUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/flights")
public class FlightController {
    private final CreateFlightUseCase createFlightUseCase;

    @PostMapping
    public Response create(@RequestBody FlightDTO dto) {
        Flight flight = dto.map(dto);
        return createFlightUseCase.create(flight, dto.getTicketPriceInEuros());
    }

//    @DeleteMapping
//    public Response delete(@RequestBody Flight flight){ return useCase.delete(flight); }
}
