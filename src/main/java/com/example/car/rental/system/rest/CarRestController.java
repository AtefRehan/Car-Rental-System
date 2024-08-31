package com.example.car.rental.system.rest;

import com.example.car.rental.system.dto.CarDto;
import com.example.car.rental.system.entity.Car;
import com.example.car.rental.system.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    private CarService carService;
    @Autowired
    public CarRestController(CarService carService) {
        System.out.println("hi");
        this.carService = carService;
    }

    @GetMapping("/car")
    List<CarDto> getAll() {
        return carService.findAll();
    }
}
