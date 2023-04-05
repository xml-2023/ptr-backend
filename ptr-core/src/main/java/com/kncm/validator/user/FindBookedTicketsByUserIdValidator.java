package com.kncm.validator.user;

import com.kncm.constant.UserConstant;
import com.kncm.store.UserStore;
import com.kncm.validator.ReadValidator;
import com.kncm.validator.ValidationReport;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class FindBookedTicketsByUserIdValidator implements ReadValidator<Long> {
    private final UserStore store;

    @Override
    public ValidationReport validate(Long id) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        if (!store.exists(id)) {
            report.setValid(false);
            report.addMessage(UserConstant.USER, "user with passed id does not exist");
        }

        return report;
    }
}
