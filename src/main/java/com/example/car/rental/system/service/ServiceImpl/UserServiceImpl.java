    package com.example.car.rental.system.service.ServiceImpl;

    import com.example.car.rental.system.dto.UserDto;
    import com.example.car.rental.system.entity.Car;
    import com.example.car.rental.system.entity.User;
    import com.example.car.rental.system.exception.handling.BaseException;
    import com.example.car.rental.system.exception.handling.enums.ErrorCode;
    import com.example.car.rental.system.mappers.CarMapper;
    import com.example.car.rental.system.mappers.UserMapper;
    import com.example.car.rental.system.repository.UserRepository;
    import com.example.car.rental.system.service.UserService;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.stereotype.Service;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;

    import java.util.List;

    @Data
    @Service
    public class UserServiceImpl implements UserService {

        private UserRepository userRepository;


        @Autowired
        public UserServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public List<UserDto> findAll() {
            return UserMapper.toDtoList(userRepository.findAll());
        }

        @Override
        public UserDto findById( Long id) {

            return UserMapper.toDto(userRepository.findById(id)
                    .orElseThrow(()->createNotFoundException(id)))
    ;
        }

//        @Override
//        public UserDto add(UserDto userDto) {
//            validateEmailUniqueness(userDto.getEmail());
//            userRepository.save(UserMapper.toEntity(userDto));
//            return userDto;
//        }

        @Override
        public UserDto update(Long id, UserDto userDto) {
            return null;
        }

        @Override
        public void delete(Long id) {

        }
        private void validateEmailUniqueness(String email) {
            if (userRepository.existsByEmail(email)) {
                throw BaseException.builder()
                        .errorCode(ErrorCode.USER_ALREADY_EXIST)
                        .details("A user with email " + email + " already exists")
                        .httpStatus(HttpStatus.CONFLICT)
                        .build();
            }
        }
        private BaseException createNotFoundException(Long id ){
            return new BaseException(ErrorCode.ID_NOT_FOUND, HttpStatus.NOT_FOUND,"user not found");
        }
    }
