package com.ztp.raffleapi.exception;

public class DomainException extends RuntimeException {
    public DomainException() {}

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }
}
