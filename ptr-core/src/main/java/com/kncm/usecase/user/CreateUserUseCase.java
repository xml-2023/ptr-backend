package com.kncm.usecase.user;

import com.kncm.dto.Response;
import com.kncm.model.User;
import com.kncm.store.UserStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.user.CreateUserValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserStore store;
    private final CreateUserValidator validator;

    public Response create(User user) {
        ValidationReport report = validator.validate(user);
        User createdUser = new User();
        if (report.isValid()) {
            createdUser = store.save(user);
        }

        return new Response(report, createdUser.getId());
    }
}
