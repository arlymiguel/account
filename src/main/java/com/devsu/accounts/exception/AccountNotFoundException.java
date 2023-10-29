package com.devsu.accounts.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Data
public class AccountNotFoundException extends RuntimeException {

    private final HttpStatus statusCode;


    public AccountNotFoundException(final String statusMessage) {
        this(HttpStatus.NOT_FOUND, statusMessage);
    }

    public AccountNotFoundException(final HttpStatus statusCode, final String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
    }

}
