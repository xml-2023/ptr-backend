package com.kncm.validator.role;

import com.kncm.constant.RoleConstant;
import com.kncm.model.Role;
import com.kncm.store.RoleStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.Validator;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

@AllArgsConstructor
public class CreateRoleValidator implements Validator<Role> {
    private final RoleStore store;

    @Override
    public ValidationReport validate(Role role) {
        ValidationReport report = new ValidationReport(true, new HashMap<>());
        if (role == null) {
            report.setValid(false);
            report.addMessage(RoleConstant.ROLE, "role is null");
        } else if (StringUtils.isBlank(role.getName())) {
            report.setValid(false);
            report.addMessage(RoleConstant.NAME, "role must have name");
        } else if (store.exists(role.getName())) {
            report.setValid(false);
            report.addMessage(RoleConstant.NAME, "role with same name already exists");
        }

        return report;
    }
}
