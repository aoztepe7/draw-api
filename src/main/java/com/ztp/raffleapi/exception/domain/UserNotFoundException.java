package com.ztp.raffleapi.exception.domain;

import com.ztp.raffleapi.message.ResponseCode;
import com.ztp.raffleapi.exception.DomainException;
import com.ztp.raffleapi.exception.ExceptionMessage;

@ExceptionMessage(responseCode = ResponseCode.USER_NOT_FOUND)
public class UserNotFoundException extends DomainException {
}
