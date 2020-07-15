package com.ztp.raffleapi.exception;

import com.ztp.raffleapi.message.ResponseCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionMessage {
    ResponseCode responseCode() default ResponseCode.UNDEFINED_ERROR;
}
