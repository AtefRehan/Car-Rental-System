package com.example.car.rental.system.service;

import com.example.car.rental.system.dto.RentalDto;
import java.util.List;

public interface RentalService {
    List<RentalDto> findAll();
    RentalDto findById(Long id);
    RentalDto save(RentalDto rentalDto);
    void deleteById(Long id);
    RentalDto update(Long id,RentalDto rentalDto);

}
