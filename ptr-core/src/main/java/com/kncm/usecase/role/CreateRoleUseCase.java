package com.kncm.usecase.role;

import com.kncm.dto.Response;
import com.kncm.model.Role;
import com.kncm.store.RoleStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.role.CreateRoleValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateRoleUseCase {
    private final RoleStore store;
    private final CreateRoleValidator validator;

    public Response create(Role role) {
        ValidationReport report = validator.validate(role);
        Role createdRole = new Role();
        if (report.isValid()) {
            createdRole = store.save(role);
        }

        return new Response(report, createdRole.getId());
    }

}
