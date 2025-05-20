package com.mg.solidaritynetwork.exception;

import com.mg.solidaritynetwork.dto.response.GlobalErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataBaseException.class)
    private ResponseEntity<GlobalErrorDTO> handleDataBaseException(DataBaseException exception) {
        GlobalErrorDTO errorDTO = new GlobalErrorDTO(HttpStatus.BAD_REQUEST.value(), "database", exception.getMessage());
        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(FormatErrorException.class)
    private ResponseEntity<GlobalErrorDTO> handleFormatErrorException(FormatErrorException exception) {
        GlobalErrorDTO errorDTO = new GlobalErrorDTO(HttpStatus.BAD_REQUEST.value(), exception.getField(), exception.getMessage());
        return ResponseEntity.badRequest().body(errorDTO);
    }
}
