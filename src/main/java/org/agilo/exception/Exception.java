package org.agilo.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Exception extends RuntimeException{
    private String error;
    private String message;
    private HttpStatus httpStatus;

    public Exception(String error, String message) {
        super(message);
        this.error = error;
        this.message = message;
    }

    public Exception(String error, String message, HttpStatus httpStatus) {
        super(message);
        this.error = error;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
