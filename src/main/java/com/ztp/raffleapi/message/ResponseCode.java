package com.ztp.raffleapi.message;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ACCESS_DENIED(400,"ACCESS DENIED"),
    USERNAME_OR_PASSWORD_INCORRECT(404,"USERNAME OR PASSWORD INCORRECT"),


    USER_NOT_FOUND(501,"USER NOT FOUND"),

    UNDEFINED_ERROR(999,"UNDEFINED ERROR");

    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
