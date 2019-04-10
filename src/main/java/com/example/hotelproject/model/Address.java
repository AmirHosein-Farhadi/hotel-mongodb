package com.example.hotelproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@NoArgsConstructor
@Document(collection = "Addresses")
public class Address {
    @Id
    private String id;
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}
