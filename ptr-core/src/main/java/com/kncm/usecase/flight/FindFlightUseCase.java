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

    public Response findFlight(Long id) {
        Response response;
        ValidationReport report = validator.validate(id);
        if (report.isValid()) {
            Flight flight = flightStore.find(id);
            response = new Response(report, flight);
        } else {
            response = new Response(report, id);
        }

        return response;
    }
}
