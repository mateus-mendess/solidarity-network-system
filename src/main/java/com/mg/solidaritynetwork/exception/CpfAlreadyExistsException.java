package com.mg.solidaritynetwork.exception;

public class CpfAlreadyExistsException extends RuntimeException {

    private String field;

    public CpfAlreadyExistsException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
