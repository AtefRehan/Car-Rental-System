package com.example.car.rental.system.rest;

import com.example.car.rental.system.dto.CarDto;
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
    CarDto Add(@RequestBody CarDto carDto) {
        carService.Add(carDto);
        return carDto;
    }

    @GetMapping("/car/{id}")
    CarDto getById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PutMapping("/car/{id}")
    CarDto update(@RequestBody CarDto carDto,@PathVariable Long id) {
        return carService.update(id,carDto);
    }

    @DeleteMapping("/car/{id}")
    void delete(@PathVariable Long id) {
        CarDto carToDelete = carService.findById(id);
        carService.delete(CarMapper.toEntity(carToDelete));
    }

}
