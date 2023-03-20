package com.kncm.validator.flight;


import com.kncm.constant.FlightConstant;
import com.kncm.model.Flight;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.Validator;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;

@AllArgsConstructor
public class CreateFlightValidator implements Validator<Flight> {
    @Override
    public ValidationReport validate(Flight flight) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        if (flight == null) {
            report.setValid(false);
            report.addMessage(FlightConstant.FLIGHT, "flight is null");
        } else {
            if (flight.getDate() == null) {
                report.setValid(false);
                report.addMessage(FlightConstant.DATE, "date is null");
            } else if (flight.getDate().isBefore(LocalDateTime.now())) {
                report.setValid(false);
                report.addMessage(FlightConstant.INVALID_DATE, "date is in past");
            }
            if (flight.getTimeOfDeparture() == null) {
                report.setValid(false);
                report.addMessage(FlightConstant.TIME_OF_DEPARTURE, "time of departure is null");
            } else if (flight.getTimeOfArrival() == null) {
                report.setValid(false);
                report.addMessage(FlightConstant.TIME_OF_ARRIVAL, "time of arrival is null");
            } else if (flight.getTimeOfArrival().isBefore(flight.getTimeOfDeparture())) {
                report.setValid(false);
                report.addMessage(FlightConstant.INVALID_TIME, "time of arrival is before time of departure");
            }
            if (flight.getPlaceOfDeparture().isBlank()) {
                report.setValid(false);
                report.addMessage(FlightConstant.PLACE_OF_DEPARTURE, "place of departure is blank");
            }
            if (flight.getPlaceOfArrival().isBlank()) {
                report.setValid(false);
                report.addMessage(FlightConstant.PLACE_OF_ARRIVAL, "place of arrival is blank");
            }
            if (flight.getPlaneCapacity() == null) {
                report.setValid(false);
                report.addMessage(FlightConstant.PLANE_CAPACITY, "plane capacity is null");
            } else if (flight.getPlaneCapacity() < flight.getNumberOfPassengers()) {
                report.setValid(false);
                report.addMessage(FlightConstant.NUMBER_OF_PASSENGERS, "number of passengers is greater than plane capacity");
            }
        }
        return report;
    }
}
