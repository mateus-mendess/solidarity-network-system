package com.mg.solidaritynetwork.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    private String field;

    public EmailAlreadyExistsException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
