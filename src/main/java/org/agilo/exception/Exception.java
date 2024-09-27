package org.agilo.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Exception extends RuntimeException{
    private String error;
    private String message;

    public Exception(String error, String message) {
        super(message);
        this.error = error;
        this.message = message;
    }
}
