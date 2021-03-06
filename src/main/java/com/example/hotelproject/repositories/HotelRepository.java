package com.example.hotelproject.repositories;

import com.example.hotelproject.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {

    Optional<Hotel> findById(String id);

    @Override
    <S extends Hotel> List<S> saveAll(Iterable<S> entities);

    List<Hotel> findByPricePerNightLessThan(int maxPrice);

    @Query(value = "{address.city:?0}")
    List<Hotel> findByCity(String city);
}
