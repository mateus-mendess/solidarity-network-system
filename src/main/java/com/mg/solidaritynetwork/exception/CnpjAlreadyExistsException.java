package com.mg.solidaritynetwork.exception;

public class CnpjAlreadyExistsException extends RuntimeException {

    private String field;

    public CnpjAlreadyExistsException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
