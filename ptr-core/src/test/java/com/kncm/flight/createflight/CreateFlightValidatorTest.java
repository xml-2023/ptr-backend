package com.kncm.flight.createflight;

import com.kncm.constant.Constant;
import com.kncm.constant.TestConstant;
import com.kncm.flight.FlightBuilder;
import com.kncm.model.Flight;
import com.kncm.validator.ValidationReport;
import com.kncm.validator.flight.CreateFlightValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class CreateFlightValidatorTest {
    private Flight flight;
    private FlightBuilder flightBuilder;
    private CreateFlightValidator validator;

    @BeforeEach
    void setUp() {
        flightBuilder = new FlightBuilder();
        flight = flightBuilder.initializeFlight();
        validator = new CreateFlightValidator();
    }

    @Test
    void validate_DateIsNull_False() {
        flight.setDate(null);

        ValidationReport report = validator.validate(flight);

        assertFalse(report.isValid());
    }

    @Test
    void validate_DateIsInPast_False() {
        flight.setDate(LocalDateTime.now().minusDays(2));

        ValidationReport report = validator.validate(flight);

        assertFalse(report.isValid());
    }

    @Test
    void validate_TimeOfArrivalIsNull_False() {
        flight.setTimeOfArrival(null);

        ValidationReport report = validator.validate(flight);

        assertFalse(report.isValid());
    }

    @Test
    void validate_TimeOfDepartureIsNull_False() {
        flight.setTimeOfDeparture(null);

        ValidationReport report = validator.validate(flight);

        assertFalse(report.isValid());
    }

    @Test
    void validate_DepartureIsAfterArrival_False() {
        flight.setTimeOfDeparture(LocalTime.now());
        flight.setTimeOfArrival(LocalTime.now().minusHours(5));

        ValidationReport report = validator.validate(flight);

        assertFalse(report.isValid());
    }

    @Test
    void validate_DeparturePlaceIsBlank_False() {
        flight.setPlaceOfDeparture(Constant.EMPTY_STRING);

        ValidationReport report = validator.validate(flight);

        assertFalse(report.isValid());
    }

    @Test
    void validate_ArrivalPlaceIsBlank_False() {
        flight.setPlaceOfArrival(Constant.EMPTY_STRING);

        ValidationReport report = validator.validate(flight);

        assertFalse(report.isValid());
    }

    @Test
    void validate_PlaneCapacityIsNull_False() {
        flight.setPlaneCapacity(null);

        ValidationReport report = validator.validate(flight);

        assertFalse(report.isValid());
    }

    @Test
    void validate_NumberOfPassengersIsGreaterThanCapacity_False() {
        flight.setPlaneCapacity(TestConstant.TEST_NUMBER_PASSENGERS);
        flight.setNumberOfPassengers(TestConstant.TEST_PLANE_CAPACITY);

        ValidationReport report = validator.validate(flight);

        assertFalse(report.isValid());
    }
}
