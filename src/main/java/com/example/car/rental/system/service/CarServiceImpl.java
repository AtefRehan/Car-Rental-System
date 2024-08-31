package com.example.car.rental.system.service;

import com.example.car.rental.system.dto.CarDto;
import com.example.car.rental.system.entity.Car;
import com.example.car.rental.system.mappers.CarMapper;
import com.example.car.rental.system.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    public CarDto findById(int id) {
        Optional<Car> car = carRepository.findById(id);
        return CarMapper.toDto(car.get());
    }


    @Transactional
    @Override
    public CarDto update(int id, CarDto carDto) {
        // Retrieve the car by ID, or throw an exception if not found
        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car with ID " + id + " not found"));

        // Update the fields of the existing car entity with the values from the DTO
        existingCar.setBrand(carDto.getBrand());
        existingCar.setModel(carDto.getModel());
        existingCar.setColor(carDto.getColor());
        existingCar.setYear(carDto.getYear());
        existingCar.setVin(carDto.getVin());
        existingCar.setAvailabilityStatus(carDto.getAvailabilityStatus());
        existingCar.setPricePerDay(carDto.getPricePerDay());
        existingCar.setSeatingCapacity(carDto.getSeatingCapacity());
        existingCar.setTransmission(carDto.getTransmissionType());
        existingCar.setFuelType(carDto.getFuelType());

        Car updatedCar = carRepository.save(existingCar);

        return CarMapper.toDto(updatedCar);
    }
//    public CarDto update(int id, CarDto car) {
////        Optional<CarD> existCar = carRepository.findById(id);
//        Car existingBook = carRepository.findById(id)
//                .orElseThrow(() -> createNotFoundException(id));
//
//        existCar.get().setBrand(car.getBrand());
//        existCar.get().setModel(car.getModel());
//        existCar.get().setYear(car.getYear());
//        existCar.get().setColor(car.getColor());
//        existCar.get().setVin(car.getVin());
//        existCar.get().setAvailabilityStatus(car.getAvailabilityStatus());
//        existCar.get().setPricePerDay(car.getPricePerDay());
//        existCar.get().setFuelType(car.getFuelType());
//        existCar.get().setTransmission(car.getTransmission());
//        existCar.get().setSeatingCapacity(car.getSeatingCapacity());
//        existCar.get().setColor(car.getColor());
//        return carRepository.save(CarMapper.toEntity(existCar));
//        return car;
//
//    }

    @Override
    public void save(CarDto carDto) {
        carRepository.save(CarMapper.toEntity(carDto));
//        CarMapper.toEntity(carDto);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }
}


