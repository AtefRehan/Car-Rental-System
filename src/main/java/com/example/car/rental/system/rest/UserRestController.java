package com.example.car.rental.system.rest;

import com.example.car.rental.system.dto.UserDto;
import com.example.car.rental.system.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserRestController {
    private  UserService userService;



    @GetMapping("/user")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.findById(id);
    }

//    @PostMapping("/user")
//    public ResponseEntity<UserDto> Add(@RequestBody UserDto userDto) {
//        UserDto createdUser = userService.add(userDto);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
}
