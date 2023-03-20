package com.kncm.entity;

import com.kncm.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("tickets")
public class TicketEntity {
    @Id
    private Long id;
    private String seat;
    private double price;
    private boolean isBooked;
    private User owner;
}
