package com.example.car.rental.system.exception.handling;

import com.example.car.rental.system.exception.handling.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleBaseException(BaseException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getMessageCode(), errorCode.getDescription(), ex.getDetails());
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());

    }

    public record ErrorResponse(String code, String description, String details) {

    }

}


