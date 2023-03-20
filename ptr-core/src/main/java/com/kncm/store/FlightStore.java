package com.kncm.store;

import com.kncm.model.Flight;

public interface FlightStore {
    Flight save(Flight flight);

    Flight find(Long id);

    boolean exists(String email);

    void delete(Flight flight);
}
