package com.kncm.controller;

import com.kncm.SequenceGenerator;
import com.kncm.dto.Response;
import com.kncm.dto.flight.FlightDTO;
import com.kncm.entity.FlightEntity;
import com.kncm.model.Flight;
import com.kncm.usecase.flight.*;
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
    private final FindAllUseCase findAllUseCase;
    private final SearchFlightsUseCase searchFlightsUseCase;
    private final SequenceGenerator generator;

    @GetMapping(value = "/findAll")
    public Response findAll() {
        return findAllUseCase.findAll();
    }

    @PostMapping
    public Response create(@RequestBody FlightDTO dto) {
        Flight flight = dto.map(dto);
        flight.setId(generator.getSequenceNumber(FlightEntity.SEQUENCE_NAME));
        return createFlightUseCase.create(flight, dto.getTicketPriceInEuros());
    }

    @GetMapping("/find/{id}")
    public Response find(@PathVariable("id") Long id) {
        return findFlightUseCase.find(id);
    }

    @GetMapping("/search")
    public Response search(
            @RequestParam String date,
            @RequestParam String placeOfDeparture,
            @RequestParam String placeOfArrival,
            @RequestParam Integer numberOfPassengers) {
        return searchFlightsUseCase.searchFlights(date, placeOfDeparture, placeOfArrival, numberOfPassengers);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        return deleteFlightUseCase.delete(id);
    }
}
