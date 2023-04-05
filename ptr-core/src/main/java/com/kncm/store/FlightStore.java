package com.kncm.store;

import com.kncm.model.Flight;

import java.util.Collection;

public interface FlightStore {
    Collection<Flight> findAll();

    Flight save(Flight flight);

    Flight find(Long id);

    boolean exists(Long id);

    Collection<Flight> search(String date, String placeOfDeparture, String placeOfArrival, Integer numberOfPassengers);

    void delete(Flight flight);

    Flight findByTicketId(Long ticketId);
}
