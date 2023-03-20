package com.kncm.entity;

import com.kncm.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("flights")
public class FlightEntity {
    @Id
    private Long id;
    private LocalDate date;
    private LocalTime timeOfDeparture;
    private String placeOfDeparture;
    private LocalTime timeOfArrival;
    private String placeOfArrival;
    private Integer numberOfPassengers;
    private Integer planeCapacity;
    private ArrayList<Ticket> tickets;
}
