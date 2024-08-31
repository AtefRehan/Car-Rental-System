package com.example.car.rental.system.service;

import com.example.car.rental.system.dto.CarDto;
import com.example.car.rental.system.entity.Car;
import com.example.car.rental.system.mappers.CarMapper;
import com.example.car.rental.system.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;


    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> findAll() {
        return CarMapper.toDtoList(carRepository.findAll());
    }

    @Override
    public Car findById(int id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElseThrow(() -> new RuntimeException("Car not found"));
    }


    @Override
    public Car update(int id, Car car) {
        Optional<Car> existCar = carRepository.findById(id);
        existCar.get().setBrand(car.getBrand());
        existCar.get().setModel(car.getModel());
        existCar.get().setYear(car.getYear());
        existCar.get().setColor(car.getColor());
        existCar.get().setVin(car.getVin());
        existCar.get().setAvailabilityStatus(car.getAvailabilityStatus());
        existCar.get().setPricePerDay(car.getPricePerDay());
        existCar.get().setFuelType(car.getFuelType());
        existCar.get().setTransmission(car.getTransmission());
        existCar.get().setSeatingCapacity(car.getSeatingCapacity());
        existCar.get().setColor(car.getColor());
        return carRepository.save(existCar.get());

    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }
}


