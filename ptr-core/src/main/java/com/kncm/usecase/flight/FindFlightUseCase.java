package com.kncm.usecase.flight;

import com.kncm.dto.Response;
import com.kncm.model.Flight;
import com.kncm.store.FlightStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.flight.FindFlightValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindFlightUseCase {
    private final FlightStore flightStore;
    private final FindFlightValidator validator;

    public Flight findFlight(Long id){
        Flight flight = flightStore.find(id);
//        ValidationReport report = validator.validate(flight);
//
//        return new Response(report, flight.getId());
        return flight;
    }
}
