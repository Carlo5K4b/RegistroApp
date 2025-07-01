package com.Cidenet.registro.infrastructure.exceptions;

import com.Cidenet.registro.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor {
    // devuelve una respuesta con un estado HTTP 400 (BAD REQUEST)
    @ExceptionHandler(NameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(NameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NOMBRE_MAX_SIZE_MESSAGE,
                LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), null));
    }

    @ExceptionHandler(OtherNamesMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleOtherNamesMaxSizeExceededException(OtherNamesMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.OTROSNOMBRES_MAX_SIZE_MESSAGE,
                LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), null));
    }

    @ExceptionHandler(LastName1MaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleLastName1MaxSizeExceededException(LastName1MaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.LASTNAME1_MAX_SIZE_MESSAGE,
                LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), null));
    }

    @ExceptionHandler(LastName2MaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleLastName2MaxSizeExceededException(LastName2MaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.LASTNAME2_MAX_SIZE_MESSAGE,
                LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), null));
    }

    @ExceptionHandler(DocumentNumberMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDocumentNumberMaxSizeExceededException(DocumentNumberMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NUMEROIDENTIFICACION_MAX_SIZE_MESSAGE,
                LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), null));
    }

    @ExceptionHandler(MailMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleMailMaxSizeExceededException(MailMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CORREO_MAX_SIZE_MESSAGE,
                LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), null));
    }

    @ExceptionHandler(RegistroEmpleadoAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleRegistroEmpleadoAlreadyExistsException(RegistroEmpleadoAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.REGISTROEMPLEADO_EXISTS_EXCEPTION,
                LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), null));
    }
    // Devuelve una respuesta para cuando los argumentos no cumplen las validaciones
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(new ExceptionResponse("Validation errors",
                LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), errors));
    }
    // Devuelve una respuesta con un estado HTTP 500 (INTERNAL SERVER ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        return ResponseEntity.internalServerError().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(), null));
    }
}

