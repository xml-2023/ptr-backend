package com.kncm.validator.flight;


import com.kncm.constant.FlightConstant;
import com.kncm.model.Flight;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.Validator;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.regex.Pattern;

@AllArgsConstructor
public class CreateFlightValidator implements Validator<Flight> {
    @Override
    public ValidationReport validate(Flight flight) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        Pattern datePattern = Pattern.compile(
                "^\\d{4}-\\d{2}-\\d{2}$");

        if (flight == null) {
            report.setValid(false);
            report.addMessage(FlightConstant.FLIGHT, "flight is null");
        } else {
            if (flight.getDate() == null) {
                report.setValid(false);
                report.addMessage(FlightConstant.DATE, "date is null");
            } else if (flight.getDate().isBefore(LocalDate.now())) {
                report.setValid(false);
                report.addMessage(FlightConstant.INVALID_DATE, "date is in past");
            } else if (!datePattern.matcher(flight.getDate().toString()).matches()) {
                report.setValid(false);
                report.addMessage(FlightConstant.INVALID_DATE, "date is in invalid format");
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
            } else if (flight.getPlaneCapacity() < 0) {
                report.setValid(false);
                report.addMessage(FlightConstant.PLANE_CAPACITY, "plane capacity cannot be negative number");
            }
        }
        return report;
    }
}
