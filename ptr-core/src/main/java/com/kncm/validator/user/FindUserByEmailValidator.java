package com.kncm.validator.user;

import com.kncm.constant.UserConstant;
import com.kncm.store.UserStore;
import com.kncm.validator.ReadValidator;
import com.kncm.validator.ValidationReport;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class FindUserByEmailValidator implements ReadValidator<String> {
    private final UserStore store;

    @Override
    public ValidationReport validate(String email) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        if (!store.exists(email)) {
            report.setValid(false);
            report.addMessage(UserConstant.USER, "user with passed email does not exist");
        }

        return report;
    }
}
