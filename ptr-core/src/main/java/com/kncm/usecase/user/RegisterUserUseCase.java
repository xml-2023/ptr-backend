package com.kncm.usecase.user;

import com.kncm.dto.Response;
import com.kncm.model.User;
import com.kncm.store.RoleStore;
import com.kncm.store.UserStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.user.CreateUserValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterUserUseCase {
    private final UserStore store;
    private final RoleStore roleStore;
    private final CreateUserValidator validator;

    public Response register(User user) {
        user.setRole(roleStore.find("REGISTERED_USER"));
        ValidationReport report = validator.validate(user);
        User createdUser = new User();
        if (report.isValid()) {
            createdUser = store.save(user);
        }

        return new Response(report, createdUser.getId());
    }
}
