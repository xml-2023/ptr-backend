package com.kncm.dto.flight;

import com.kncm.model.Flight;
import com.kncm.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {
    private Long id;
    private String date;
    private String timeOfArrival;
    private String timeOfDeparture;
    private String placeOfArrival;
    private String placeOfDeparture;
    private Integer planeCapacity;
    private Integer numberOfPassengers = 0;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private double ticketPriceInEuros;

    public Flight map(FlightDTO dto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Flight flight = new Flight();
        flight.setId(dto.getId());
        flight.setDate(LocalDate.parse(dto.getDate()).plusDays(1));
        flight.setTimeOfArrival(LocalTime.parse(dto.getTimeOfArrival()).plusHours(1));
        flight.setTimeOfDeparture(LocalTime.parse(dto.getTimeOfDeparture()).plusHours(1));
        flight.setPlaceOfArrival(dto.getPlaceOfArrival());
        flight.setPlaceOfDeparture(dto.getPlaceOfDeparture());
        flight.setPlaneCapacity(dto.getPlaneCapacity());
        flight.setTickets(dto.getTickets());
        flight.setNumberOfPassengers(dto.getNumberOfPassengers());

        return flight;
    }
}
