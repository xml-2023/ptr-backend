package com.kncm.usecase.flight;

import com.kncm.dto.Response;
import com.kncm.model.Flight;
import com.kncm.store.FlightStore;
import com.kncm.validator.ValidationReport;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.HashMap;

@RequiredArgsConstructor
public class FindAllUseCase {
    private final FlightStore flightStore;

    public Response findAll(){
        Response response;
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        Collection<Flight> flights = flightStore.findAll();
        response = new Response(report, flights);
        return response;
    }
}
