package com.example.car.rental.system.mappers;

import com.example.car.rental.system.dto.RentalDto;
import com.example.car.rental.system.entity.Car;
import com.example.car.rental.system.entity.Rental;
import com.example.car.rental.system.entity.User;

import java.util.ArrayList;
import java.util.List;

public class RentalMapper {


    public static List<RentalDto>toDtoList(List<Rental> rentals) {
        List<RentalDto> rentalDtos = new ArrayList<>();
        for (Rental rental : rentals) {
            rentalDtos.add(toDto(rental));
        }
        return rentalDtos;
    }
    public static RentalDto toDto(Rental rental) {
        RentalDto Rentaldto = new RentalDto();
        Rentaldto.setId(rental.getId());
        Rentaldto.setUserId(rental.getUser().getId());
        Rentaldto.setCarId(rental.getCar().getId());
        Rentaldto.setRentalStatus(rental.getRentalStatus());
        Rentaldto.setRentalStartDate(rental.getRentalStartDate());
        Rentaldto.setRentalEndDate(rental.getRentalEndDate());
        Rentaldto.setTotalAmount(rental.getTotalAmount());
        return Rentaldto;

    }

    public static Rental toEntity(RentalDto rentalDto, User user, Car car) {
        Rental rental = new Rental();
        rental.setId(rentalDto.getId());
        rental.setUser(user);
        rental.setCar(car);
        rental.setRentalStatus(rentalDto.getRentalStatus());
        rental.setRentalStartDate(rentalDto.getRentalStartDate());
        rental.setRentalEndDate(rentalDto.getRentalEndDate());
        rental.setTotalAmount(rentalDto.getTotalAmount());
        return rental;
    }
}
