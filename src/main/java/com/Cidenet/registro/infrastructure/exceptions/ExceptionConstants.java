package com.Cidenet.registro.infrastructure.exceptions;

public class ExceptionConstants {
    // Constructor privado para evitar la instanciación de la clase.
    private ExceptionConstants(){}

    public static final String NOMBRE_MAX_SIZE_MESSAGE = "El nombre no puede exceder los 20 caracteres.";
    public static final String OTROSNOMBRES_MAX_SIZE_MESSAGE = "Otros nombres no puede exceder los 50 caracteres.";
    public static final String LASTNAME1_MAX_SIZE_MESSAGE = "El apellido no puede exceder los 20 caracteres.";
    public static final String LASTNAME2_MAX_SIZE_MESSAGE = "El apellido no puede exceder los 20 caracteres.";
    public static final String NUMEROIDENTIFICACION_MAX_SIZE_MESSAGE = "El número de identificación no puede exceder los 20 caracteres.";
    public static final String CORREO_MAX_SIZE_MESSAGE = "El correo electrónico no puede exceder los 300 caracteres.";

    //indica que la categoría ya existe.
    public static final String REGISTROEMPLEADO_EXISTS_EXCEPTION = "El registro del empleado ya existe";
}
