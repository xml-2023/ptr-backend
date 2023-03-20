package com.kncm.flight.createflight;

import com.kncm.flight.FlightBuilder;
import com.kncm.model.Flight;
import com.kncm.store.FlightStore;
import com.kncm.usecase.flight.CreateFlightUseCase;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.flight.CreateFlightValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateFlightUseCaseTest {
    private final ValidationReport validReport = new ValidationReport(true, new HashMap<>());
    private final ValidationReport invalidReport = new ValidationReport(false, new HashMap<>());
    private Flight flight;
    @Mock
    CreateFlightValidator validator;
    @Mock
    FlightStore store;
    private CreateFlightUseCase useCase;
    private FlightBuilder flightBuilder;

    @BeforeEach
    void setUp() {
        flightBuilder = new FlightBuilder();
        flight = flightBuilder.initializeFlight();
        useCase = new CreateFlightUseCase(store, validator);
    }

    @Test
    void create_FlightIsValid_True() {
        when(store.save(flight))
                .thenReturn(flight);
        when(validator.validate(flight))
                .thenReturn(validReport);

        useCase.create(flight);

        verify(store, times(1)).save(flight);
    }

    @Test
    void create_FlightIsNotValid_False() {
        when(validator.validate(flight))
                .thenReturn(invalidReport);

        useCase.create(flight);

        verify(store, times(0)).save(flight);
    }
}
