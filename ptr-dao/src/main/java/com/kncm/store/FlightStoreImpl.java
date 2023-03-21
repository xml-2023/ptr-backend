package com.kncm.store;

import com.kncm.converter.FlightConverter;
import com.kncm.model.Flight;
import com.kncm.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class FlightStoreImpl implements FlightStore{
    private final FlightRepository repository;
    private final FlightConverter converter;
    private final MongoTemplate mongoTemplate;

    @Override
    public Flight save(Flight flight) { return converter.toModel(repository.save(converter.toEntity(flight))); }

    @Override
    public Flight find(Long id) { return converter.toModel(repository.findOne(id)); }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Collection<Flight> search(String date, String placeOfDeparture, String placeOfArrival, Integer numberOfPassengers) {
        var query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        LocalDate flightDate = LocalDate.parse(date);

          if (placeOfDeparture != null && !placeOfDeparture.isBlank())
              criteria.add(Criteria.where("placeOfDeparture").is(placeOfDeparture));
          if (placeOfArrival != null && !placeOfArrival.isBlank())
              criteria.add(Criteria.where("placeOfArrival").is(placeOfArrival));
          if (flightDate != null)
              criteria.add(Criteria.where("date").is(flightDate));
//          if (numberOfPassengers != null && numberOfPassengers > 0)
//              criteria.add(Criteria.where("planeCapacity - numberOfPassengers").gte(numberOfPassengers));
          if (!criteria.isEmpty()) {
              query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
          }

        List<Flight> flights = mongoTemplate.find(query, Flight.class, "flights");

        return flights;
    }

    @Override
    public void delete(Flight flight) { repository.delete(converter.toEntity(flight)); }
}
