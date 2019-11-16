package com.facultysys.errors;

import org.springframework.http.HttpStatus;

public class ConficException extends BaseException {


    public ConficException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
