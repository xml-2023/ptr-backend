package com.kncm.controller;

import com.kncm.dto.Response;
import com.kncm.model.User;
import com.kncm.usecase.user.CreateUserUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public Response create(@RequestBody User user) {
        return createUserUseCase.create(user);
    }
}
