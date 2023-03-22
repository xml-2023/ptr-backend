package com.kncm.validator.user;

import com.kncm.constant.UserConstant;
import com.kncm.model.User;
import com.kncm.store.RoleStore;
import com.kncm.store.UserStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.Validator;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class CreateUserValidator implements Validator<User> {
    private final UserStore store;
    private final RoleStore roleStore;

    @Override
    public ValidationReport validate(User user) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        if (user == null) {
            report.setValid(false);
            report.addMessage(UserConstant.USER, "user is null");
        } else {
            if (user.getName() == null || user.getName().isBlank()) {
                report.setValid(false);
                report.addMessage(UserConstant.NAME, "name is blank");
            }
            if (user.getSurname() == null || user.getSurname().isBlank()) {
                report.setValid(false);
                report.addMessage(UserConstant.SURNAME, "surname is blank");
            }
            if (user.getEmail() == null || user.getEmail().isBlank()) {
                report.setValid(false);
                report.addMessage(UserConstant.EMAIL, "email is blank");
            } else if (store.exists(user.getEmail())) {
                report.setValid(false);
                report.addMessage(UserConstant.EMAIL, "user with this email address is already registered");
            }
            if (user.getPassword() == null || user.getPassword().isBlank()) {
                report.setValid(false);
                report.addMessage(UserConstant.PASSWORD, "password is blank");
            }
            if (user.getRole() != null) {
                if (!roleStore.exists(user.getRole().getName())) {
                    report.setValid(false);
                    report.addMessage(UserConstant.ROLE, "role does not exist");
                }
            } else {
                report.setValid(false);
                report.addMessage(UserConstant.ROLE, "role is null");
            }
        }

        return report;
    }
}
