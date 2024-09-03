package com.example.car.rental.system.repository;

import com.example.car.rental.system.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
