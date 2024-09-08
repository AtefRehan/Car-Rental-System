package com.example.car.rental.system.service.ServiceImpl;

import com.example.car.rental.system.dto.CarDto;
import com.example.car.rental.system.entity.Car;
import com.example.car.rental.system.exception.handling.BaseException;
import com.example.car.rental.system.exception.handling.enums.ErrorCode;
import com.example.car.rental.system.mappers.CarMapper;
import com.example.car.rental.system.repository.CarRepository;
import com.example.car.rental.system.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public CarDto findById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> createNotFoundException(id));
        return CarMapper.toDto(car);
    }


    @Transactional
    @Override
    public CarDto update(Long id, CarDto carDto) {
        // Retrieve the car by ID, or throw an exception if not found
        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> createNotFoundException(id));

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

    @Transactional
    @Override
    public void Add(CarDto carDto) {
        System.out.println("Adding Car ...");
        validateCarUniqueness(carDto.getVin());
        carRepository.save(CarMapper.toEntity(carDto));

    }

    @Transactional
    @Override
    public void delete(Car car) {
        System.out.println("Deleting car " + car.getVin());
        carRepository.delete(car);
    }


    //Validations
    private void validateCarUniqueness(String vin) {
        if (carRepository.existsCarByVin(vin)) {
            throw BaseException.builder()
                    .errorCode(ErrorCode.CAR_ALREADY_EXIST)
                    .details("A Car With Vin " + vin + " Already Exists!")
                    .httpStatus(HttpStatus.CONFLICT)
                    .build();
        }
    }

    private BaseException createNotFoundException(Long id) {
        return new BaseException(ErrorCode.ID_NOT_FOUND,HttpStatus.NOT_FOUND,"Car with ID " + id + " Not Found!");
    }


}

