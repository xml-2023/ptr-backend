package com.kncm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private Long id;
    private String seat;
    private double price;
    private boolean isBooked;
    private User owner;
}
