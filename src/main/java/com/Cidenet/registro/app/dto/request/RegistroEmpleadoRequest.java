package com.Cidenet.registro.app.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record RegistroEmpleadoRequest(
        @NotNull(message = "no puede ser nulo - test message")
        @NotBlank String nombre,
        @NotBlank String otrosNombres,
        @NotBlank String apellido1,
        @NotBlank String apellido2,
        @NotBlank String pais,
        @NotBlank String tipoIdentificacion,
        @NotBlank String numeroIdentificacion,
        @NotBlank String correo,
        @NotBlank String fechaIngreso,
        @NotBlank String area,
        @NotBlank String estado,
        @NotNull @NotBlank String fechaHoraR
) {}