package com.kncm.user.finduserbyemail;

import com.kncm.constant.UserConstant;
import com.kncm.store.UserStore;
import com.kncm.usecase.user.FindUserByEmailUseCase;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.user.FindUserByEmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindUserByEmailUseCaseTest {
    private final ValidationReport validReport = new ValidationReport(true, new HashMap<>());
    private final ValidationReport invalidReport = new ValidationReport(false, new HashMap<>());
    @Mock
    FindUserByEmailValidator validator;
    @Mock
    UserStore store;
    private FindUserByEmailUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new FindUserByEmailUseCase(store, validator);
    }

    @Test
    void find_Valid_True() {
        when(validator.validate(UserConstant.EMAIL))
                .thenReturn(validReport);

        useCase.find(UserConstant.EMAIL);

        verify(store, times(1)).find(UserConstant.EMAIL);
    }

    @Test
    void find_Invalid_False() {
        when(validator.validate(UserConstant.EMAIL))
                .thenReturn(invalidReport);

        useCase.find(UserConstant.EMAIL);

        verify(store, times(0)).find(UserConstant.EMAIL);
    }
}
