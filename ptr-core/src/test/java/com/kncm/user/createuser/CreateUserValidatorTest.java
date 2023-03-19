package com.kncm.user.createuser;

import com.kncm.constant.Constant;
import com.kncm.model.User;
import com.kncm.role.RoleBuilder;
import com.kncm.store.RoleStore;
import com.kncm.store.UserStore;
import com.kncm.user.UserBuilder;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.user.CreateUserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateUserValidatorTest {
    private User user;
    private UserBuilder userBuilder;
    private RoleBuilder roleBuilder;
    private CreateUserValidator validator;
    @Mock
    private UserStore store;
    @Mock
    private RoleStore roleStore;

    @BeforeEach
    void setUp() {
        roleBuilder = new RoleBuilder();
        userBuilder = new UserBuilder(roleBuilder);
        user = userBuilder.initializeUser();
        validator = new CreateUserValidator(store, roleStore);
    }

    @Test
    void validate_NameIsBlank_False() {
        user.setName(Constant.EMPTY_STRING);

        ValidationReport report = validator.validate(user);

        assertFalse(report.isValid());
    }

    @Test
    void validate_SurnameIsBlank_False() {
        user.setSurname(Constant.EMPTY_STRING);

        ValidationReport report = validator.validate(user);

        assertFalse(report.isValid());
    }

    @Test
    void validate_EmailIsBlank_False() {
        user.setEmail(Constant.EMPTY_STRING);

        ValidationReport report = validator.validate(user);

        assertFalse(report.isValid());
    }

    @Test
    void validate_PasswordIsBlank_False() {
        user.setPassword(Constant.EMPTY_STRING);

        ValidationReport report = validator.validate(user);

        assertFalse(report.isValid());
    }

    @Test
    void validate_RoleDoesNotExist_False() {
        when(roleStore.exists(user.getRole().getName()))
                .thenReturn(false);

        ValidationReport report = validator.validate(user);

        assertFalse(report.isValid());
    }

    @Test
    void validate_EmailAlreadyExists_False() {
        when(store.exists(user.getEmail()))
                .thenReturn(true);

        ValidationReport report = validator.validate(user);

        assertFalse(report.isValid());
    }

    @Test
    void validate_Valid_True() {
        when(store.exists(user.getEmail()))
                .thenReturn(false);
        when(roleStore.exists(user.getRole().getName()))
                .thenReturn(true);

        ValidationReport report = validator.validate(user);

        assertTrue(report.isValid());
    }

}
