package com.kncm.store;

import com.kncm.converter.FlightConverter;
import com.kncm.model.Flight;
import com.kncm.repository.FlightRepository;
import com.mongodb.BasicDBObject;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class FlightStoreImpl implements FlightStore {
    private final FlightRepository repository;
    private final FlightConverter converter;
    private final MongoTemplate mongoTemplate;

    @Override
    public Collection<Flight> findAll() {
        return converter.toModel(repository.findAll());
    }

    @Override
    public Flight save(Flight flight) {
        return converter.toModel(repository.save(converter.toEntity(flight)));
    }

    @Override
    public Flight find(Long id) {
        return converter.toModel(repository.findOne(id));
    }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Collection<Flight> search(String date, String placeOfDeparture, String placeOfArrival, Integer numberOfPassengers) {
        var query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        LocalDate flightDate = LocalDate.parse(date);
        List<Flight> flights = new ArrayList<>();

        if (placeOfDeparture != null && !placeOfDeparture.isBlank())
            criteria.add(Criteria.where("placeOfDeparture").is(placeOfDeparture));
        if (placeOfArrival != null && !placeOfArrival.isBlank())
            criteria.add(Criteria.where("placeOfArrival").is(placeOfArrival));
        if (flightDate != null)
            criteria.add(Criteria.where("date").is(flightDate));
        if (numberOfPassengers != null && numberOfPassengers > 0) {
            criteria.add(Criteria.where("$expr")
                    .gte(Arrays.asList(
                            new BasicDBObject("$subtract", Arrays.asList("$planeCapacity", "$numberOfPassengers")),
                            numberOfPassengers
                    ))
            );
        }
        if (criteria.size() == 4) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
            flights = mongoTemplate.find(query, Flight.class, "flights");
        }

        return flights;
    }

    @Override
    public void delete(Flight flight) {
        repository.delete(converter.toEntity(flight));
    }

    @Override
    public Flight findByTicketId(Long ticketId) {
        return converter.toModel(repository.findByTicketsId(ticketId));
    }

}
