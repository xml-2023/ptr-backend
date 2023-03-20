package com.kncm.usecase.flight;

import com.kncm.dto.Response;
import com.kncm.model.Flight;
import com.kncm.store.FlightStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.flight.CreateFlightValidator;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class CreateFlightUseCase {
    private final FlightStore store;
    private final CreateFlightValidator validator;

    public Response create(Flight flight){
        ValidationReport report = validator.validate(flight);
        Flight createdFlight = new Flight();
        //create ticket list
        createdFlight.setTickets(new ArrayList<>());
        createdFlight.setNumberOfPassengers(0);
        if (report.isValid()) {
            createdFlight = store.save(flight);
        }

        return new Response(report, createdFlight.getId());
    }
}
