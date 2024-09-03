package com.example.car.rental.system.rest;

import com.example.car.rental.system.dto.CarDto;
import com.example.car.rental.system.entity.Car;
import com.example.car.rental.system.mappers.CarMapper;
import com.example.car.rental.system.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    private CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car")
    List<CarDto> getAll() {
        return carService.findAll();
    }

    @PostMapping("/car")
    CarDto save(@RequestBody CarDto carDto) {
        carService.save(carDto);
        return carDto;
    }

    @GetMapping("/car/{id}")
    CarDto getById(@PathVariable int id) {
        return carService.findById(id);
    }

    @PutMapping("/car/{id}")
    CarDto update(@RequestBody CarDto carDto,@PathVariable int id) {
        return carService.update(id,carDto);
    }

    @DeleteMapping("/car/{id}")
    void delete(@PathVariable int id) {
        CarDto carToDelete = carService.findById(id);
        carService.delete(CarMapper.toEntity(carToDelete));
    }

}
