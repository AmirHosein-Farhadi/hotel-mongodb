package com.example.hotelproject.controllers;

import com.example.hotelproject.model.Hotel;
import com.example.hotelproject.repositories.HotelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){

        return this.hotelRepository.findAll();
    }

    @PutMapping
    public void insert(@RequestBody Hotel hotel){
        this.hotelRepository.insert(hotel);
    }

    @PostMapping
    public void update(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id){
        Optional<Hotel> hotelOptional = this.hotelRepository.findById(id);

        //todo check if its present

        return hotelOptional.get();
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){

        return this.hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){

        return this.hotelRepository.findByCity(city);
    }
}
