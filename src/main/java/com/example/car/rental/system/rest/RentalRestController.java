package com.example.car.rental.system.rest;

import com.example.car.rental.system.dto.RentalDto;
import com.example.car.rental.system.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RentalRestController {

    private final RentalService rentalService;

    @Autowired
    public RentalRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/rental")
    public ResponseEntity<List<RentalDto>> findAll() {
        List<RentalDto> rentals = rentalService.findAll();
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/rental/{id}")
    public ResponseEntity<RentalDto> findById(@PathVariable Long id) {
        RentalDto rentalDto = rentalService.findById(id);
        if (rentalDto != null) {
            return ResponseEntity.ok(rentalDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/rental")
    public ResponseEntity<RentalDto> add(@RequestBody RentalDto rentalDto) {
        RentalDto createdRental = rentalService.Add(rentalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRental);
    }

    @DeleteMapping("/rental/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        rentalService.delete(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/rental/{id}")
    public ResponseEntity<RentalDto> update(@PathVariable Long id, @RequestBody RentalDto rentalDto) {
        return new ResponseEntity<>(rentalService.update(id, rentalDto), HttpStatus.OK);

    }
}
