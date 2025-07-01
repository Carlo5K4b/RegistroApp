package com.Cidenet.registro.app.dto.response;

public record RegistroEmpleadoResponse(String nombre, String otrosNombres, String apellido1, String apellido2,
                                       String país,String tipoIdentificacion, String numeroIdentificacion, String correo,
                                       String fechaIngreso, String area, String estado, String fechaHoraR) {
}
