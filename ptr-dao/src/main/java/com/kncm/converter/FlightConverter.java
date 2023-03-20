package com.kncm.converter;

import com.kncm.entity.FlightEntity;
import com.kncm.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightConverter implements GenericConverter<Flight, FlightEntity>{
    @Override
    public Flight toModel(FlightEntity flightEntity) {
        Flight flight = new Flight();
        flight.setId(flightEntity.getId());
        flight.setPlaneCapacity(flightEntity.getPlaneCapacity());
        flight.setDate(flightEntity.getDate());
        flight.setTickets(flightEntity.getTickets());
        flight.setNumberOfPassengers(flightEntity.getNumberOfPassengers());
        flight.setPlaceOfArrival(flightEntity.getPlaceOfArrival());
        flight.setPlaceOfDeparture(flightEntity.getPlaceOfDeparture());
        flight.setTimeOfDeparture(flightEntity.getTimeOfDeparture());
        flight.setTimeOfArrival(flightEntity.getTimeOfArrival());
        return flight;
    }

    @Override
    public List<Flight> toModel(List<FlightEntity> flightEntities) {
        List<Flight> flights = new ArrayList<>();
        for(FlightEntity flightEntity : flightEntities){
            Flight flight = new Flight();
            flight.setId(flightEntity.getId());
            flight.setPlaneCapacity(flightEntity.getPlaneCapacity());
            flight.setDate(flightEntity.getDate());
            flight.setTickets(flightEntity.getTickets());
            flight.setNumberOfPassengers(flightEntity.getNumberOfPassengers());
            flight.setPlaceOfArrival(flightEntity.getPlaceOfArrival());
            flight.setPlaceOfDeparture(flightEntity.getPlaceOfDeparture());
            flight.setTimeOfDeparture(flightEntity.getTimeOfDeparture());
            flight.setTimeOfArrival(flightEntity.getTimeOfArrival());
            flights.add(flight);
        }
        return flights;
    }

    @Override
    public FlightEntity toEntity(Flight flight) {
        FlightEntity entity = new FlightEntity();
        entity.setId(flight.getId());
        entity.setTickets(flight.getTickets());
        entity.setDate(flight.getDate());
        entity.setPlaceOfDeparture(flight.getPlaceOfDeparture());
        entity.setPlaceOfArrival(flight.getPlaceOfArrival());
        entity.setNumberOfPassengers(flight.getNumberOfPassengers());
        entity.setTimeOfArrival(flight.getTimeOfArrival());
        entity.setTimeOfDeparture(flight.getTimeOfDeparture());
        entity.setPlaneCapacity(flight.getPlaneCapacity());

        return entity;
    }

    @Override
    public List<FlightEntity> toEntity(List<Flight> flights) {
        List<FlightEntity> entities = new ArrayList<>();
        for(Flight flight : flights){
            FlightEntity entity = new FlightEntity();
            entity.setId(flight.getId());
            entity.setTickets(flight.getTickets());
            entity.setDate(flight.getDate());
            entity.setPlaceOfDeparture(flight.getPlaceOfDeparture());
            entity.setPlaceOfArrival(flight.getPlaceOfArrival());
            entity.setNumberOfPassengers(flight.getNumberOfPassengers());
            entity.setTimeOfArrival(flight.getTimeOfArrival());
            entity.setTimeOfDeparture(flight.getTimeOfDeparture());
            entity.setPlaneCapacity(flight.getPlaneCapacity());
            entities.add(entity);
        }
        return entities;
    }
}
