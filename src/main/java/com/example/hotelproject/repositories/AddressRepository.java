package com.example.hotelproject.repositories;

import com.example.hotelproject.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface AddressRepository extends MongoRepository<Address, String> {
}
