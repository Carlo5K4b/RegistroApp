package com.Cidenet.registro.domain.models;
import com.Cidenet.registro.domain.exceptions.NameMaxSizeExceededException;
import com.Cidenet.registro.domain.utils.constants.DomainConstants;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

import static com.Cidenet.registro.domain.utils.constants.DomainConstants.*;

public class RegistroEmpleadoModel {
    //@Pattern(regexp = "^[A-Z]+$", message = "Solo se permiten letras mayúsculas de la A a la Z")

    private String nombre;
    private String otrosNombres;
    private String apellido1;
    private String apellido2;
    private String pais;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String correo;
    private String fechaIngreso;
    private String area;
    private String estado;
    private String fechaHoraR;

    public RegistroEmpleadoModel(String nombre, String otrosNombres, String apellido1,
                                 String apellido2, String pais, String tipoIdentificacion,
                                 String numeroIdentificacion, String correo, String fechaIngreso,
                                 String area, String estado, String fechaHoraR)  {
        if (nombre.length() > REGISTROE_FIELD_NOMBRE_MAX_SIZE){
            throw new NameMaxSizeExceededException();
        }

        if (otrosNombres.length() > REGISTROE_FIELD_OTROSNOMBRES_MAX_SIZE){
            throw new NameMaxSizeExceededException();
        }
        if (apellido1.length() > REGISTROE_FIELD_APELLIDOS_MAX_SIZE){
            throw new NameMaxSizeExceededException();
        }

        if (apellido2.length() > REGISTROE_FIELD_APELLIDOS_MAX_SIZE){
            throw new NameMaxSizeExceededException();
        }

        if (numeroIdentificacion.length() > REGISTROE_FIELD_NUMEROIDENTIFICACION_MAX_SIZE){
            throw new NameMaxSizeExceededException();
        }

        if (correo.length() > REGISTROE_FIELD_CORREO_MAX_SIZE){
            throw new NameMaxSizeExceededException();
        }

        this.nombre = Objects.requireNonNull(nombre, DomainConstants.FIELD_NOMBRE_NULL_MESSAGE);
        //this.otrosNombres = Objects.requireNonNull(otrosNombres, DomainConstants.FIELD_OTROSNOMBRES_NULL_MESSAGE);
        this.apellido1 = Objects.requireNonNull(apellido1, DomainConstants.FIELD_APELLIDOS_NULL_MESSAGE);
        this.apellido2 = Objects.requireNonNull(apellido2, DomainConstants.FIELD_APELLIDOS_NULL_MESSAGE);
        this.pais = Objects.requireNonNull(pais, DomainConstants.FIELD_PAIS_NULL_MESSAGE);
        this.tipoIdentificacion = Objects.requireNonNull(tipoIdentificacion, DomainConstants.FIELD_TIPOIDENTIFICACION_NULL_MESSAGE);
        this.numeroIdentificacion = Objects.requireNonNull(numeroIdentificacion, DomainConstants.FIELD_NUMEROIDENTIFICACION_NULL_MESSAGE);
        this.correo = Objects.requireNonNull(correo, DomainConstants.FIELD_CORREO_NULL_MESSAGE);
        this.fechaIngreso = Objects.requireNonNull(fechaIngreso, DomainConstants.FIELD_FECHAINGRESO_NULL_MESSAGE);
        this.area = Objects.requireNonNull(area, DomainConstants.FIELD_AREA_NULL_MESSAGE);
        this.estado = Objects.requireNonNull(estado, DomainConstants.FIELD_ESTADO_NULL_MESSAGE);
        this.fechaHoraR = Objects.requireNonNull(fechaHoraR,  DomainConstants.FIELD_FECHAHORAR_NULL_MESSAGE);
    }

    public String getNombre() {return nombre;}

    public String getOtrosNombres() {return otrosNombres;}

    public String getApellido1() {return apellido1;}

    public String getApellido2() {return apellido2;}

    public String getPais() {return pais;}

    public String getTipoIdentificacion() {return tipoIdentificacion;}

    public String getNumeroIdentificacion() {return numeroIdentificacion;}

    public String getCorreo() {return correo;}

    public String getFechaIngreso() {return fechaIngreso;}

    public String getArea() {return area;}

    public String getEstado() {return estado;}

    public String getFechaHoraR() {return fechaHoraR;}

    public void setNombre(String nombre) {
        if (nombre == null || !nombre.matches(SOLO_MAYUSCULAS_REGEX) || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'nombre' no puede ser nulo o vacío.");
        }
        if (nombre.length() > REGISTROE_FIELD_NOMBRE_MAX_SIZE) {
            throw new NameMaxSizeExceededException();
        }
        this.nombre = Objects.requireNonNull(nombre, DomainConstants.FIELD_NOMBRE_NULL_MESSAGE);
    }

    public void setOtrosNombres(String otrosNombres) {
        if (otrosNombres == null || !otrosNombres.matches(SOLO_MAYUSCULAS_REGEX) || otrosNombres.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'otros nombres' no pueden ser nulos o vacíos.");
        }
        if (otrosNombres.length() > REGISTROE_FIELD_OTROSNOMBRES_MAX_SIZE) {
            throw new NameMaxSizeExceededException();
        }
        //this.otrosNombres = Objects.requireNonNull(otrosNombres, DomainConstants.FIELD_OTROSNOMBRES_NULL_MESSAGE);
    }

    public void setApellido1(String apellido1) {
        if (apellido1 == null || !apellido1.matches(SOLO_MAYUSCULAS_REGEX) || apellido1.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'apellido' no puede ser nulo o vacío.");
        }
        if (apellido1.length() > REGISTROE_FIELD_APELLIDOS_MAX_SIZE) {
            throw new NameMaxSizeExceededException();
        }
        this.apellido1 = Objects.requireNonNull(apellido1, DomainConstants.FIELD_APELLIDOS_NULL_MESSAGE);
    }

    public void setApellido2(String apellido2) {
        if (apellido2 == null || !apellido2.matches(SOLO_MAYUSCULAS_REGEX) || apellido2.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'apellido' no puede ser nulo o vacío.");
        }
        if (apellido2.length() > REGISTROE_FIELD_APELLIDOS_MAX_SIZE) {
            throw new NameMaxSizeExceededException();
        }
        this.apellido2 = Objects.requireNonNull(apellido2, DomainConstants.FIELD_APELLIDOS_NULL_MESSAGE);
    }

    public void setPais(String pais) {
        if (pais == null || !pais.matches(SOLO_MAYUSCULAS_REGEX) || pais.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'país' no puede ser nulo o vacío.");
        }
        this.pais = Objects.requireNonNull(pais, DomainConstants.FIELD_PAIS_NULL_MESSAGE);
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        if (tipoIdentificacion == null || !tipoIdentificacion.matches(SOLO_MAYUSCULAS_REGEX) || tipoIdentificacion.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'tipo de identificación' no puede ser nulo o vacío.");
        }
        this.tipoIdentificacion = Objects.requireNonNull(tipoIdentificacion, DomainConstants.FIELD_TIPOIDENTIFICACION_NULL_MESSAGE);
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        if (numeroIdentificacion == null || !numeroIdentificacion.matches(SOLO_MAYUSCULAS_REGEX) || numeroIdentificacion.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'número de identificación' no puede ser nulo o vacío.");
        }
        if (numeroIdentificacion.length() > REGISTROE_FIELD_NUMEROIDENTIFICACION_MAX_SIZE) {
            throw new NameMaxSizeExceededException();
        }
        this.numeroIdentificacion = Objects.requireNonNull(numeroIdentificacion, DomainConstants.FIELD_NUMEROIDENTIFICACION_NULL_MESSAGE);
    }

    public void setCorreo(String correo) {
        if (correo == null || !correo.matches(SOLO_MAYUSCULAS_REGEX) || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'correo electrónico' no puede ser nulo o vacío.");
        }
        if (correo.length() > REGISTROE_FIELD_CORREO_MAX_SIZE) {
            throw new NameMaxSizeExceededException();
        }
        this.correo = Objects.requireNonNull(correo, DomainConstants.FIELD_CORREO_NULL_MESSAGE);
    }

    public void setFechaIngreso(String fechaIngreso) {
        if (fechaIngreso == null || !fechaIngreso.matches(SOLO_MAYUSCULAS_REGEX) || fechaIngreso.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'fecha de ingreso' no puede ser nulo o vacío.");
        }
        this.fechaIngreso = Objects.requireNonNull(fechaIngreso, DomainConstants.FIELD_FECHAINGRESO_NULL_MESSAGE);
    }

    public void setArea(String area) {
        if (area == null || !area.matches(SOLO_MAYUSCULAS_REGEX) || area.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'área' no puede ser nulo o vacío.");
        }
        this.area = Objects.requireNonNull(area, DomainConstants.FIELD_AREA_NULL_MESSAGE);
    }

    public void setEstado(String estado) {
        if (estado == null || !estado.matches(SOLO_MAYUSCULAS_REGEX) || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'estado' no puede ser nulo o vacío.");
        }
        this.estado = Objects.requireNonNull(estado, DomainConstants.FIELD_ESTADO_NULL_MESSAGE);
    }

    public void setFechaHoraR(String fechaHoraR) {
        if (fechaHoraR == null || !fechaHoraR.matches(SOLO_MAYUSCULAS_REGEX) || fechaHoraR.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo 'fecha Hora del registro' no puede ser nulo o vacío.");
        }
        this.fechaHoraR = Objects.requireNonNull(fechaHoraR, DomainConstants.FIELD_FECHAHORAR_NULL_MESSAGE);
    }
}

