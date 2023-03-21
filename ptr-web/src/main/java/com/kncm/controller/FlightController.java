package com.kncm.controller;

import com.kncm.dto.flight.FlightDTO;
import com.kncm.dto.Response;
import com.kncm.model.Flight;
import com.kncm.store.FlightStore;
import com.kncm.usecase.flight.CreateFlightUseCase;
import com.kncm.usecase.flight.DeleteFlightUseCase;
import com.kncm.usecase.flight.FindFlightUseCase;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/flights")
public class FlightController {
    private final CreateFlightUseCase createFlightUseCase;
    private final DeleteFlightUseCase deleteFlightUseCase;
    private final FindFlightUseCase findFlightUseCase;
    private final FlightStore flightStore;

    @PostMapping
    public Response create(@RequestBody FlightDTO dto) {
        Flight flight = dto.map(dto);
        return createFlightUseCase.create(flight, dto.getTicketPriceInEuros());
    }

    @GetMapping(value = "/findBy/{id}")
    public Response findOne(@PathVariable("id") Long id){
        return findFlightUseCase.findFlight(id);
    }
    @DeleteMapping(value = "/{id}")
    public Response delete(@PathVariable("id") Long id){
        return deleteFlightUseCase.delete(id);
    }
}
