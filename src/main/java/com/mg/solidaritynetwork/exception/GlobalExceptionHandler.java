package com.mg.solidaritynetwork.exception;

import com.mg.solidaritynetwork.dto.response.GlobalErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataBaseException.class)
    private ResponseEntity<GlobalErrorResponse> handleDataBaseException(DataBaseException exception) {
        GlobalErrorResponse errorDTO = new GlobalErrorResponse(HttpStatus.BAD_REQUEST.value(), "database", exception.getMessage());
        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(InvalidFormatException.class)
    private ResponseEntity<GlobalErrorResponse> handleInvalidFormatException(InvalidFormatException exception) {
        GlobalErrorResponse errorDTO = new GlobalErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getField(), exception.getMessage());
        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    private ResponseEntity<GlobalErrorResponse> handleEmailAlreadyExistException(EmailAlreadyExistsException exception) {
        GlobalErrorResponse errorResponse = new GlobalErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getField(), exception.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(CpfAlreadyExistsException.class)
    private ResponseEntity<GlobalErrorResponse> handleCpfAlreadyExistsException(CpfAlreadyExistsException exception) {
        GlobalErrorResponse globalErrorResponse = new GlobalErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getField(), exception.getMessage());
        return ResponseEntity.badRequest().body(globalErrorResponse);
    }

    @ExceptionHandler(CnpjAlreadyExistsException.class)
    private ResponseEntity<GlobalErrorResponse> handleCpfAlreadyExistsException(CnpjAlreadyExistsException exception) {
        GlobalErrorResponse globalErrorResponse = new GlobalErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getField(), exception.getMessage());
        return ResponseEntity.badRequest().body(globalErrorResponse);
    }

}
