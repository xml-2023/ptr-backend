package com.kncm.user.finduserbyemail;

import com.kncm.constant.UserConstant;
import com.kncm.store.UserStore;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.user.FindUserByEmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindUserByEmailValidatorTest {
    @Mock
    UserStore store;
    FindUserByEmailValidator validator;

    @BeforeEach
    void setUp() {
        validator = new FindUserByEmailValidator(store);
    }

    @Test
    void validate_UserWithPassedEmailDoesNotExist_False() {
        when(store.exists(UserConstant.EMAIL))
                .thenReturn(false);

        ValidationReport report = validator.validate(UserConstant.EMAIL);

        assertFalse(report.isValid());
    }

    @Test
    void validate_Valid_True() {
        when(store.exists(UserConstant.EMAIL))
                .thenReturn(true);

        ValidationReport report = validator.validate(UserConstant.EMAIL);

        assertTrue(report.isValid());
    }
}
