package com.example.car.rental.system.service;

import com.example.car.rental.system.dto.CarDto;
import com.example.car.rental.system.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<CarDto> findAll();
    Car findById(int id);
    Car update(int id,Car car);
    void save(Car car);
    void delete(Car car);
}
