package com.kncm.controller;

import com.kncm.SequenceGenerator;
import com.kncm.dto.Response;
import com.kncm.entity.UserEntity;
import com.kncm.model.User;
import com.kncm.usecase.user.CreateUserUseCase;
import com.kncm.usecase.user.FindBookedTicketsByUserIdUseCase;
import com.kncm.usecase.user.FindUserByEmailUseCase;
import com.kncm.usecase.user.RegisterUserUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final RegisterUserUseCase registerUserUseCase;
    private final FindUserByEmailUseCase findUserByEmailUseCase;
    private final FindBookedTicketsByUserIdUseCase findBookedTicketsByUserIdUseCase;
    private final SequenceGenerator generator;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public Response create(@RequestBody User user) {
        user.setId(generator.getSequenceNumber(UserEntity.SEQUENCE_NAME));
        return createUserUseCase.create(user);
    }

    @PostMapping("register")
    public Response register(@RequestBody User user) {
        user.setId(generator.getSequenceNumber(UserEntity.SEQUENCE_NAME));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return registerUserUseCase.register(user);
    }

    @GetMapping("find/{email}")
    public Response user(@PathVariable String email) {
        return findUserByEmailUseCase.find(email);
    }

    @GetMapping("/{id}/tickets")
    public Response tickets(@PathVariable Long id) {
        return findBookedTicketsByUserIdUseCase.findTickets(id);
    }
}
