package com.example.car.rental.system.service.ServiceImpl;

import com.example.car.rental.system.dto.RentalDto;
import com.example.car.rental.system.mappers.RentalMapper;
import com.example.car.rental.system.repository.RentalRepository;
import com.example.car.rental.system.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService
{
    RentalRepository rentalRepository;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<RentalDto> findAll() {
        return RentalMapper.toDtoList(rentalRepository.findAll());
    }

    @Override
    public RentalDto findById(Long id) {
        return null;
    }

    @Override
    public RentalDto save(RentalDto rentalDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public RentalDto update(Long id, RentalDto rentalDto) {
        return null;
    }
}
