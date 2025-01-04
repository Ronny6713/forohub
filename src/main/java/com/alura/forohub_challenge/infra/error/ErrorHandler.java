package com.alura.forohub_challenge.infra.error;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    //update error
    @ExceptionHandler(ValidationExceptionApi.class)
    public ResponseEntity<String> handleValidationException(ValidationExceptionApi e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException e) {
        var error = e.getFieldErrors().stream().map(ErrorData::new).toList();
        return ResponseEntity.badRequest().body(error);
    }

    public record ErrorData(String field, String error) {
        public ErrorData(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
