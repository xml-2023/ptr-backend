package com.kncm.role.createrole;

import com.kncm.constant.Constant;
import com.kncm.model.Role;
import com.kncm.role.RoleBuilder;
import com.kncm.store.RoleStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.role.CreateRoleValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateRoleValidatorTest {
    private Role role;
    private RoleBuilder roleBuilder;
    private CreateRoleValidator validator;
    @Mock
    RoleStore store;

    @BeforeEach
    void setUp() {
        roleBuilder = new RoleBuilder();
        role = roleBuilder.initializeRole();
        validator = new CreateRoleValidator(store);
    }

    @Test
    void validate_NameIsBlank_False() {
        role.setName(Constant.EMPTY_STRING);

        ValidationReport report = validator.validate(role);

        assertFalse(report.isValid());
    }

    @Test
    void validate_NameAlreadyExists_False() {
        when(store.exists(role.getName()))
                .thenReturn(true);

        ValidationReport report = validator.validate(role);

        assertFalse(report.isValid());
    }

    @Test
    void validate_Valid_True() {
        when(store.exists(role.getName()))
                .thenReturn(false);

        ValidationReport report = validator.validate(role);

        assertTrue(report.isValid());
    }
}
