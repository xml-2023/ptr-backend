package com.kncm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private Long id;
    private LocalDateTime date;
    private LocalTime timeOfDeparture;
    private String placeOfDeparture;
    private LocalTime timeOfArrival;
    private String placeOfArrival;
    private Integer numberOfPassengers;
    private Integer planeCapacity;
    private ArrayList<Ticket> tickets;
}
