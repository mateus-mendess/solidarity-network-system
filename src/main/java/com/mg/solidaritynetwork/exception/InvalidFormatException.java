package com.mg.solidaritynetwork.exception;

public class InvalidFormatException extends RuntimeException {
   private String field;

    public InvalidFormatException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
