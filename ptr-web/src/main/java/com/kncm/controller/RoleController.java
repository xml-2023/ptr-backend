package com.kncm.controller;

import com.kncm.SequenceGenerator;
import com.kncm.dto.Response;
import com.kncm.entity.RoleEntity;
import com.kncm.model.Role;
import com.kncm.usecase.role.CreateRoleUseCase;
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
@RequestMapping("/roles")
public class RoleController {
    private final CreateRoleUseCase createRoleUseCase;
    private final SequenceGenerator generator;

    @PostMapping
    public Response create(@RequestBody Role role) {
        role.setId(generator.getSequenceNumber(RoleEntity.SEQUENCE_NAME));
        return createRoleUseCase.create(role);
    }
}
