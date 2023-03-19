package com.kncm.role.createrole;

import com.kncm.model.Role;
import com.kncm.role.RoleBuilder;
import com.kncm.store.RoleStore;
import com.kncm.usecase.role.CreateRoleUseCase;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.role.CreateRoleValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateRoleUseCaseTest {
    private final ValidationReport validReport = new ValidationReport(true, new HashMap<>());
    private final ValidationReport invalidReport = new ValidationReport(false, new HashMap<>());
    private Role role;
    private RoleBuilder roleBuilder;
    @Mock
    private CreateRoleValidator validator;
    @Mock
    private RoleStore store;
    private CreateRoleUseCase useCase;

    @BeforeEach
    void setUp() {
        roleBuilder = new RoleBuilder();
        role = roleBuilder.initializeRole();
        useCase = new CreateRoleUseCase(store, validator);
    }

    @Test
    void create_RoleIsValid_True() {
        when(store.save(role))
                .thenReturn(role);
        when(validator.validate(role))
                .thenReturn(validReport);

        useCase.create(role);

        verify(store, times(1)).save(role);
    }

    @Test
    void create_RoleIsNotValid_False() {
        when(validator.validate(role))
                .thenReturn(invalidReport);

        useCase.create(role);

        verify(store, times(0)).save(role);
    }
}

