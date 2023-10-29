package com.devsu.accounts.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Data
public class MovementNotFoundException extends RuntimeException {

    private final HttpStatus statusCode;


    public MovementNotFoundException(final String statusMessage) {
        this(HttpStatus.NOT_FOUND, statusMessage);
    }

    public MovementNotFoundException(final HttpStatus statusCode, final String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
    }

}
