package com.example.car.rental.system.exception.handling.enums;


import lombok.Getter;

@Getter
public enum ErrorCode {
    CAR_ALREADY_EXIST("car exist","The Car Vin Already Exists"),
    ID_NOT_FOUND("not.exist","ID Not Found"),
    INTERNAL_SERVER_ERROR("internal.error", "An internal server error occurred");

    ;

    private final String messageCode;
    private final String description;

    ErrorCode(String messageCode, String description) {
        this.messageCode = messageCode;
        this.description = description;
    }

}
