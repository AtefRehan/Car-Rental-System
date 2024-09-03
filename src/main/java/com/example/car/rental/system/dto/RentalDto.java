package com.example.car.rental.system.dto;

import com.example.car.rental.system.enums.rental.RentalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDto {
    private Long id;
    private Long userId;
    private Long carId;
    private Date rentalStartDate;
    private Date rentalEndDate;
    private RentalStatus rentalStatus;
    private double totalAmount;
}
