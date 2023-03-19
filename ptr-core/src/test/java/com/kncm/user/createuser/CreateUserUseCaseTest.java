package com.kncm.user.createuser;

import com.kncm.model.User;
import com.kncm.role.RoleBuilder;
import com.kncm.store.UserStore;
import com.kncm.usecase.user.CreateUserUseCase;
import com.kncm.user.UserBuilder;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.user.CreateUserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {
    private final ValidationReport validReport = new ValidationReport(true, new HashMap<>());
    private final ValidationReport invalidReport = new ValidationReport(false, new HashMap<>());
    private User user;
    private UserBuilder userBuilder;
    private RoleBuilder roleBuilder;
    @Mock
    CreateUserValidator validator;
    @Mock
    UserStore store;
    private CreateUserUseCase useCase;

    @BeforeEach
    void setUp() {
        roleBuilder = new RoleBuilder();
        userBuilder = new UserBuilder(roleBuilder);
        user = userBuilder.initializeUser();
        useCase = new CreateUserUseCase(store, validator);
    }

    @Test
    void create_UserIsValid_True() {
        when(store.save(user))
                .thenReturn(user);
        when(validator.validate(user))
                .thenReturn(validReport);

        useCase.create(user);

        verify(store, times(1)).save(user);
    }

    @Test
    void create_UserIsNotValid_False() {
        when(validator.validate(user))
                .thenReturn(invalidReport);

        useCase.create(user);

        verify(store, times(0)).save(user);
    }
}
