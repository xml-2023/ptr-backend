package com.kncm.dto.flight;

import com.kncm.model.Flight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {
    private String date;
    private String timeOfArrival;
    private String timeOfDeparture;
    private String placeOfArrival;
    private String placeOfDeparture;
    private Integer planeCapacity;
    private double ticketPriceInEuros;

    public Flight map(FlightDTO dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Flight flight = new Flight();
        flight.setDate(LocalDate.parse(dto.getDate()));
        flight.setTimeOfArrival(LocalTime.parse(dto.getTimeOfArrival()));
        flight.setTimeOfDeparture(LocalTime.parse(dto.getTimeOfDeparture()));
        flight.setPlaceOfArrival(dto.getPlaceOfArrival());
        flight.setPlaceOfDeparture(dto.getPlaceOfDeparture());
        flight.setPlaneCapacity(dto.getPlaneCapacity());

        return flight;
    }
}
