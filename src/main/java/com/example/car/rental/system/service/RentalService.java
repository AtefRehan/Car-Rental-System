package com.example.car.rental.system.service;

import com.example.car.rental.system.dto.RentalDto;
import com.example.car.rental.system.entity.Rental;

import java.util.List;

public interface RentalService {
    List<RentalDto> findAll();
    RentalDto findById(Long id);
    RentalDto Add(RentalDto rentalDto);
    void delete(long id);
    RentalDto update(Long id,RentalDto rentalDto);

}
