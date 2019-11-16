package com.facultysys.errors;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {


    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
