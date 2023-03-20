package com.kncm.flight;

import com.kncm.constant.FlightConstant;
import com.kncm.constant.TestConstant;
import com.kncm.model.Flight;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class FlightBuilder {

    public Flight initializeFlight() {
        Flight flight = new Flight();
        flight.setId(TestConstant.TEST_ID);
        flight.setDate(TestConstant.TEST_DATE);
        flight.setTimeOfArrival(TestConstant.TEST_TIME_ARRIVAL);
        flight.setTimeOfDeparture(TestConstant.TEST_TIME_DEPARTURE);
        flight.setPlaceOfArrival(FlightConstant.PLACE_OF_ARRIVAL);
        flight.setPlaceOfDeparture(FlightConstant.PLACE_OF_DEPARTURE);
        flight.setPlaceOfDeparture(FlightConstant.PLACE_OF_DEPARTURE);
        flight.setPlaneCapacity(TestConstant.TEST_PLANE_CAPACITY);
        flight.setNumberOfPassengers(TestConstant.TEST_NUMBER_PASSENGERS);
        flight.setTickets(new ArrayList<>());
        return flight;
    }
}
