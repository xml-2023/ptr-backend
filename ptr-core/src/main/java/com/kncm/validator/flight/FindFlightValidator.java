package com.kncm.validator.flight;

import com.kncm.constant.FlightConstant;
import com.kncm.model.Flight;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.Validator;

import java.util.HashMap;

public class FindFlightValidator implements Validator<Flight> {
    @Override
    public ValidationReport validate(Flight flight) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        if (flight == null) {
            report.setValid(false);
            report.addMessage(FlightConstant.FLIGHT, "flight is null");
        }
        return report;
    }
}
