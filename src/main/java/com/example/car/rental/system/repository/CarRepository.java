package com.example.car.rental.system.repository;

import com.example.car.rental.system.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
