package com.kncm.store;

import com.kncm.model.Flight;

public interface FlightStore {
    Flight save(Flight flight);

    Flight find(Long id);
    boolean exists(Long id);

    void delete(Flight flight);
}
