package com.kncm.validator.flight;

import com.kncm.constant.FlightConstant;
import com.kncm.store.FlightStore;
import com.kncm.validator.ReadValidator;
import com.kncm.validator.ValidationReport;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class FindFlightValidator implements ReadValidator<Long> {
    private final FlightStore store;

    @Override
    public ValidationReport validate(Long id) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        if (!store.exists(id)) {
            report.setValid(false);
            report.addMessage(FlightConstant.FLIGHT, "flight with passed id does not exist");
        }

        return report;
    }
}
