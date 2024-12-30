package com.alura.forohub_challenge.domain;

public class ValidationExceptionApi extends RuntimeException {
    public ValidationExceptionApi(String message) {
        super(message);
    }
}
