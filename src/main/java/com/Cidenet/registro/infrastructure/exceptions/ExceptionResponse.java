package com.Cidenet.registro.infrastructure.exceptions;

import java.time.LocalDateTime;
import java.util.List;
public record ExceptionResponse(String message, LocalDateTime timestamp, int status, List<String> errors) {
}