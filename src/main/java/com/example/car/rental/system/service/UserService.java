package com.example.car.rental.system.service;

import com.example.car.rental.system.dto.UserDto;
import com.example.car.rental.system.entity.User;

import java.util.List;

public interface UserService {

    public List<UserDto> findAll();
    public UserDto findById(Long id);
//    public UserDto add(UserDto user);
    public UserDto update(Long id,UserDto userDto);
    public void delete(Long id);

}
