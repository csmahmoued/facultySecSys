package com.facultysys.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDestails> handleApiException(BaseException ex, WebRequest request){

        ErrorDestails errors=new ErrorDestails(ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity<>(errors,ex.getStatusCode());
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        VaildationErrors ver=new VaildationErrors();
        ver.setUri(request.getDescription(false));
        List<FieldError> fieldErrors=ex.getBindingResult().getFieldErrors();
        for(FieldError f:fieldErrors){
            ver.addError(f.getDefaultMessage());
        }

            return new ResponseEntity<>(ver,HttpStatus.BAD_REQUEST);
    }
}
