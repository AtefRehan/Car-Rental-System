package com.example.car.rental.system.service.ServiceImpl;

import com.example.car.rental.system.dto.RentalDto;
import com.example.car.rental.system.entity.Car;
import com.example.car.rental.system.entity.Rental;
import com.example.car.rental.system.entity.User;
import com.example.car.rental.system.exception.handling.BaseException;
import com.example.car.rental.system.exception.handling.enums.ErrorCode;
import com.example.car.rental.system.mappers.RentalMapper;
import com.example.car.rental.system.repository.CarRepository;
import com.example.car.rental.system.repository.RentalRepository;
import com.example.car.rental.system.repository.UserRepository;
import com.example.car.rental.system.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {
    RentalRepository rentalRepository;
    UserRepository userRepository;
    CarRepository carRepository;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository, UserRepository userRepository, CarRepository carRepository) {

        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public List<RentalDto> findAll() {
        return RentalMapper.toDtoList(rentalRepository.findAll());
    }

    @Override
    public RentalDto findById(Long id) {
        Optional<Rental> rental = rentalRepository.findById(id);
        if (!rental.isPresent()) {
            throw new BaseException(ErrorCode.ID_NOT_FOUND, HttpStatus.NOT_FOUND, "the id " + id + "is not found ");

        } else return RentalMapper.toDto(rental.get());

    }

    @Override
    public RentalDto Add(RentalDto rentalDto) {
        User user = userRepository.findById(rentalDto.getUserId()).orElseThrow(() -> createNotFoundException(rentalDto.getUserId(), "User with ID " + rentalDto.getUserId() + " Not Found!"));

        System.out.println("the user id is " + user.getId());
        Car car = carRepository.findById(rentalDto.getCarId()).orElseThrow(() -> createNotFoundException(rentalDto.getCarId(), "Car with ID " + rentalDto.getCarId() + " Not Found!"));

        Rental rental = RentalMapper.toEntity(rentalDto, user, car);

        Rental savedRental = rentalRepository.save(rental);

        return RentalMapper.toDto(savedRental);
    }


    @Override
    public void delete(long id) {
        if (!rentalRepository.existsById(id)) {
            throw createNotFoundException(id, "Rental with Id " + id + " is Not Found !");
        }
        System.out.println("Rental with id " + id + " deleted successfully");
        rentalRepository.deleteById(id);
    }

    @Override
    public RentalDto update(Long id, RentalDto rentalDto) {

        User user = userRepository.findById(rentalDto.getUserId()).orElseThrow(() -> createNotFoundException(rentalDto.getUserId(), "User with ID " + rentalDto.getUserId() + " Not Found!"));

        Car car = carRepository.findById(rentalDto.getCarId()).orElseThrow(() -> createNotFoundException(rentalDto.getCarId(), "Car with ID " + rentalDto.getCarId() + " Not Found!"));

        Rental rental = rentalRepository.findById(id).orElseThrow(() -> createNotFoundException(id, "Rental with ID " + id + " is not found !"));


        updateRentalFields(rentalDto,rental, car,user);

        rentalRepository.save(rental);

        return RentalMapper.toDto(rental);

    }

    private BaseException createNotFoundException(Long id, String details) {
        return new BaseException(ErrorCode.ID_NOT_FOUND, HttpStatus.NOT_FOUND, details);
    }

    private void updateRentalFields(RentalDto rentalDto,Rental rental, Car car , User user){

        rental.setCar(car);
        rental.setUser(user);
        rental.setRentalStatus(rentalDto.getRentalStatus());
        rental.setRentalStartDate(rentalDto.getRentalStartDate());
        rental.setRentalEndDate(rentalDto.getRentalEndDate());
        rental.setTotalAmount(rentalDto.getTotalAmount());
    }

}
