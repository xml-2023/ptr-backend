package com.kncm.flight.createflight;

import com.kncm.constant.TestConstant;
import com.kncm.flight.FlightBuilder;
import com.kncm.model.Flight;
import com.kncm.store.FlightStore;
import com.kncm.store.TicketStore;
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
    FlightStore flightStore;
    @Mock
    TicketStore ticketStore;
    private CreateFlightUseCase useCase;
    private FlightBuilder flightBuilder;

    @BeforeEach
    void setUp() {
        flightBuilder = new FlightBuilder();
        flight = flightBuilder.initializeFlight();
        useCase = new CreateFlightUseCase(flightStore, ticketStore, validator);
    }

    @Test
    void create_FlightIsValid_True() {
        when(flightStore.save(flight))
                .thenReturn(flight);
        when(validator.validate(flight))
                .thenReturn(validReport);

        useCase.create(flight, TestConstant.TEST_TICKET_PRICE);

        verify(flightStore, times(1)).save(flight);
    }

    @Test
    void create_FlightIsNotValid_False() {
        when(validator.validate(flight))
                .thenReturn(invalidReport);

        useCase.create(flight, TestConstant.TEST_TICKET_PRICE);

        verify(flightStore, times(0)).save(flight);
    }
}
