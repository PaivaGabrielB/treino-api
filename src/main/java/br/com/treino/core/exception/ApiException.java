package br.com.treino.core.exception;

import org.springframework.http.HttpStatus;

import java.util.Collections;

public class ApiException extends RuntimeException {

    private ErrorResponse errorResponse;

    public ApiException(String message) {
        super(message);
        errorResponse = new ErrorResponse();
        errorResponse.setDetail(message);
        errorResponse.setMessage(Collections.singletonList(message));
        errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
    }

    public ApiException(String message, Exception e) {
        super(message);
        e.printStackTrace();
        errorResponse = new ErrorResponse();
        errorResponse.setDetail(e.getMessage());
        errorResponse.setMessage(Collections.singletonList(message));
        errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
    }

    public ApiException(String message, String details) {
        super(message);
        errorResponse = new ErrorResponse();
        errorResponse.setDetail(details);
        errorResponse.setMessage(Collections.singletonList(message));
        errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
    }
}
