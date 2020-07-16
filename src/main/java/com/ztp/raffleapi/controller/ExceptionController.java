package com.ztp.raffleapi.controller;

import com.ztp.raffleapi.exception.DomainException;
import com.ztp.raffleapi.exception.ExceptionMessage;
import com.ztp.raffleapi.message.BaseResponse;
import com.ztp.raffleapi.message.ResponseCode;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseResponse accessDeniedHandler(AccessDeniedException e) {
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.ACCESS_DENIED.getCode());
        response.setMessage(ResponseCode.ACCESS_DENIED.getMessage());
        return response;
    }

    @ExceptionHandler({DomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse domainExceptionHandler(DomainException e) {
        ExceptionMessage exceptionMessage = AnnotationUtils.findAnnotation(e.getClass(), ExceptionMessage.class);
        BaseResponse response = new BaseResponse();
        assert exceptionMessage != null;
        response.setCode(exceptionMessage.responseCode().getCode());
        response.setMessage(exceptionMessage.responseCode().getMessage());
        return response;
    }


   /* @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public BaseResponse failedLoginHandler() {
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.USERNAME_OR_PASSWORD_INCORRECT.getCode());
        response.setMessage(ResponseCode.USERNAME_OR_PASSWORD_INCORRECT.getMessage());
        return response;
    }*/
}
