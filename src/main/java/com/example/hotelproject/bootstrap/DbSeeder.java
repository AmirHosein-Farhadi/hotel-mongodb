package com.example.hotelproject.bootstrap;

import com.example.hotelproject.model.Address;
import com.example.hotelproject.model.Hotel;
import com.example.hotelproject.model.Review;
import com.example.hotelproject.repositories.AddressRepository;
import com.example.hotelproject.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;
    private AddressRepository addressRepository;

    public DbSeeder(HotelRepository hotelRepository, AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Address marriot_address = new Address("Paris", "France");

        Hotel marriot = new Hotel(
                "Marriot",
                130,
                marriot_address,
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )
        );

        Address ibis_address = new Address("Bucharest", "Romania");
        Hotel ibis = new Hotel(
                "Ibis",
                90,
                ibis_address,
                Collections.singletonList(
                        new Review("Teddy", 9, true)
                )
        );

        Address sofitel_address = new Address("Rome", "Italy");

        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                sofitel_address,
                new ArrayList<>()
        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to the database
        List<Address> addresses = Arrays.asList(marriot_address, ibis_address, sofitel_address);
        List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);

        this.addressRepository.saveAll(addresses);
        this.hotelRepository.saveAll(hotels);
    }
}
