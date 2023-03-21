package com.kncm.store;

import com.kncm.converter.FlightConverter;
import com.kncm.model.Flight;
import com.kncm.repository.FlightRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FlightStoreImpl implements FlightStore{
    private final FlightRepository repository;
    private final FlightConverter converter;

    @Override
    public Flight save(Flight flight) { return converter.toModel(repository.save(converter.toEntity(flight))); }

    @Override
    public Flight find(Long id) { return converter.toModel(repository.findOne(id)); }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void delete(Flight flight) { repository.delete(converter.toEntity(flight)); }
}
