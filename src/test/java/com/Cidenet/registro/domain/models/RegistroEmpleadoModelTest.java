// src/test/java/com/Cidenet/registro/domain/models/RegistroEmpleadoModelTest.java
package com.Cidenet.registro.domain.models;

import com.Cidenet.registro.domain.exceptions.NameMaxSizeExceededException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroEmpleadoModelTest {

    @Test
    void testConstructorDatosValidos() {
        RegistroEmpleadoModel registro = new RegistroEmpleadoModel(
                "NOMBRE", "OTROSNOMBRES", "APELLIDO1", "APELLIDO2", "PAIS",
                "TIPO", "ID123", "correo@dominio.com", "2024-06-01", "AREA", "ACTIVO", "2024-06-01T10:00"
        );
        assertEquals("NOMBRE", registro.getNombre());
        assertEquals("OTROSNOMBRES", registro.getOtrosNombres());
        assertEquals("APELLIDO1", registro.getApellido1());
        assertEquals("APELLIDO2", registro.getApellido2());
        assertEquals("PAIS", registro.getPais());
        assertEquals("TIPO", registro.getTipoIdentificacion());
        assertEquals("ID123", registro.getNumeroIdentificacion());
        assertEquals("correo@dominio.com", registro.getCorreo());
        assertEquals("2024-06-01", registro.getFechaIngreso());
        assertEquals("AREA", registro.getArea());
        assertEquals("ACTIVO", registro.getEstado());
        assertEquals("2024-06-01T10:00", registro.getFechaHoraR());
    }

    @Test
    void testConstructorNombreExcedeLimite() {
        String nombreLargo = "A".repeat(21); // Ajusta el límite según tu constante
        assertThrows(NameMaxSizeExceededException.class, () ->
                new RegistroEmpleadoModel(
                        nombreLargo, "OTROSNOMBRES", "APELLIDO1", "APELLIDO2", "PAIS",
                        "TIPO", "ID123", "correo@dominio.com", "2024-06-01", "AREA", "ACTIVO", "2024-06-01T10:00"
                )
        );
    }

    @Test
    void testSetNombreNuloOLimpio() {
        RegistroEmpleadoModel registro = new RegistroEmpleadoModel(
                "NOMBRE", "OTROSNOMBRES", "APELLIDO1", "APELLIDO2", "PAIS",
                "TIPO", "ID123", "correo@dominio.com", "2024-06-01", "AREA", "ACTIVO", "2024-06-01T10:00"
        );
        assertThrows(IllegalArgumentException.class, () -> registro.setNombre(null));
        assertThrows(IllegalArgumentException.class, () -> registro.setNombre("   "));
    }

    @Test
    void testSetNumeroIdentificacionExcedeLimite() {
        RegistroEmpleadoModel registro = new RegistroEmpleadoModel(
                "NOMBRE", "OTROSNOMBRES", "APELLIDO1", "APELLIDO2", "PAIS",
                "TIPO", "ID123", "correo@dominio.com", "2024-06-01", "AREA", "ACTIVO", "2024-06-01T10:00"
        );
        String idLargo = "X".repeat(21); // Ajusta el límite según tu constante
        assertThrows(NameMaxSizeExceededException.class, () -> registro.setNumeroIdentificacion(idLargo));
    }

    /*@Test
    void testSetCorreoExcedeLimite() {
        RegistroEmpleadoModel registro = new RegistroEmpleadoModel(
                "NOMBRE", "OTROSNOMBRES", "APELLIDO1", "APELLIDO2", "PAIS",
                "TIPO", "ID123", "correo@dominio.com", "2024-06-01", "AREA", "ACTIVO", "2024-06-01T10:00"
        );
        String correoLargo = "a".repeat(101) + "@dominio.com"; // Ajusta el límite según tu constante
        assertThrows(NameMaxSizeExceededException.class, () -> registro.setCorreo(correoLargo));
    }*/
}