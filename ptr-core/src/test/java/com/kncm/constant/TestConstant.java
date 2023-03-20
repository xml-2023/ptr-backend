package com.kncm.constant;

import java.time.LocalDate;
import java.time.LocalTime;

public final class TestConstant {
    public static final Long TEST_ID = 1L;
    public static final LocalDate TEST_DATE = LocalDate.now().plusDays(5);
    public static final LocalTime TEST_TIME_ARRIVAL = LocalTime.now().plusHours(2);
    public static final LocalTime TEST_TIME_DEPARTURE = LocalTime.now();
    public static final Integer TEST_PLANE_CAPACITY = 50;
    public static final Integer TEST_NUMBER_PASSENGERS = 35;
}
