package com.example.car.rental.system.mappers;

import com.example.car.rental.system.dto.CarDto;
import com.example.car.rental.system.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarMapper {

    private CarMapper() {
    }


    public static List<CarDto> toDtoList(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        cars.forEach(car -> {
            carDtos.add(toDto(car));
        });
        return carDtos;
    }

    public static CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setBrand(car.getBrand());
        carDto.setModel(car.getModel());
        carDto.setColor(car.getColor());
        carDto.setYear(car.getYear());
        carDto.setVin(car.getVin());
        carDto.setAvailabilityStatus(car.getAvailabilityStatus());
        carDto.setPricePerDay(car.getPricePerDay());
        carDto.setSeatingCapacity(car.getSeatingCapacity());
        carDto.setTransmissionType(car.getTransmission());
        carDto.setFuelType(car.getFuelType());
        return carDto;
    }

    public static Car toEntity(CarDto carDto) {
        Car car = new Car();
        car.setId(carDto.getId());
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setColor(carDto.getColor());
        car.setYear(carDto.getYear());
        car.setVin(carDto.getVin());
        car.setAvailabilityStatus(carDto.getAvailabilityStatus());
        car.setPricePerDay(carDto.getPricePerDay());
        car.setSeatingCapacity(carDto.getSeatingCapacity());
        car.setTransmission(carDto.getTransmissionType());
        car.setFuelType(carDto.getFuelType());
        return car;
    }

}
