package com.example.car.rental.system.mappers;

import com.example.car.rental.system.dto.UserDto;
import com.example.car.rental.system.entity.User;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class UserMapper {

    public static List<UserDto> toDtoList(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            userDtos.add(UserMapper.toDto(user));
        });
        return userDtos;
    }
    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;

    }
    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }

}
