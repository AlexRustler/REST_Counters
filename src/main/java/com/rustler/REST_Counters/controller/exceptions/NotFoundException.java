package com.rustler.REST_Counters.controller.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message, null);
    }
}
