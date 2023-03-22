package com.kncm.controller;

import com.kncm.SequenceGenerator;
import com.kncm.dto.Response;
import com.kncm.entity.UserEntity;
import com.kncm.model.User;
import com.kncm.usecase.user.CreateUserUseCase;
import com.kncm.usecase.user.RegisterUserUseCase;
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
    private final RegisterUserUseCase registerUserUseCase;
    private final SequenceGenerator generator;

    @PostMapping
    public Response create(@RequestBody User user) {
        user.setId(generator.getSequenceNumber(UserEntity.SEQUENCE_NAME));
        return createUserUseCase.create(user);
    }

    @PostMapping("register")
    public Response register(@RequestBody User user) {
        user.setId(generator.getSequenceNumber(UserEntity.SEQUENCE_NAME));
        return registerUserUseCase.register(user);
    }
}
