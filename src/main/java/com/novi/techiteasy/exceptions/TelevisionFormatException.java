package com.novi.techiteasy.exceptions;

import java.io.Serial;

public class TelevisionFormatException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public TelevisionFormatException() {
        super();
    }
    public TelevisionFormatException(String message) {
        super(message);
    }
}
