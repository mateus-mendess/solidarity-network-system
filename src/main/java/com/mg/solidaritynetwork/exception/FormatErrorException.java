package com.mg.solidaritynetwork.exception;

public class FormatErrorException extends RuntimeException {
   private String field;

    public FormatErrorException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
