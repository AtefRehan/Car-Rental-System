package com.example.car.rental.system.rest;

import com.example.car.rental.system.dto.RentalDto;
import com.example.car.rental.system.entity.Rental;
import com.example.car.rental.system.mappers.RentalMapper;
import com.example.car.rental.system.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RentalRestController {
    private  RentalService rentalService;

    @Autowired
    public RentalRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/rental")
    public List<RentalDto> findAll() {
      return rentalService.findAll();
    }
    @GetMapping("/rental/{id}")
    public RentalDto findById(@PathVariable Long id) {
        return rentalService.findById(id);
    }
}
