package com.devsu.accounts.exception;

import org.springframework.http.HttpStatus;

public class BalanceException extends  RuntimeException{

    private final HttpStatus statusCode;


    public BalanceException(final String statusMessage) {
        this(HttpStatus.BAD_REQUEST, statusMessage);
    }

    public BalanceException(final HttpStatus statusCode, final String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
    }

}
