package com.kncm.usecase.user;

import com.kncm.dto.Response;
import com.kncm.model.User;
import com.kncm.store.UserStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.user.FindUserByEmailValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindUserByEmailUseCase {
    private final UserStore store;
    private final FindUserByEmailValidator validator;

    public Response find(String email) {
        Response response;
        ValidationReport report = validator.validate(email);
        if (report.isValid()) {
            User user = store.find(email);
            response = new Response(report, user);
        } else {
            response = new Response(report, email);
        }

        return response;
    }
}
