package com.kncm.controller;

import com.kncm.SequenceGenerator;
import com.kncm.dto.Response;
import com.kncm.dto.flight.FlightDTO;
import com.kncm.entity.FlightEntity;
import com.kncm.model.Flight;
import com.kncm.store.FlightStore;
import com.kncm.usecase.flight.CreateFlightUseCase;
import com.kncm.usecase.flight.DeleteFlightUseCase;
import com.kncm.usecase.flight.FindFlightUseCase;
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
    private final DeleteFlightUseCase deleteFlightUseCase;
    private final FindFlightUseCase findFlightUseCase;
    private final SequenceGenerator generator;

    @PostMapping
    public Response create(@RequestBody FlightDTO dto) {
        Flight flight = dto.map(dto);
        flight.setId(generator.getSequenceNumber(FlightEntity.SEQUENCE_NAME));
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
