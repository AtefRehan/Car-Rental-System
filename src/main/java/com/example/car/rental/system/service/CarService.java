package com.example.car.rental.system.service;

import com.example.car.rental.system.dto.CarDto;
import com.example.car.rental.system.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<CarDto> findAll();
    CarDto findById(int id);
    CarDto update(int id,CarDto carDto);
    void save(CarDto carDto);
    void delete(Car car);
}
