package com.Cidenet.registro.commons.constans;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    //Un mensaje constante que indica que el registro ha sido creada exitosamente.
    public static final String SAVE_REGISTROEMPLEADO_RESPONSE_MESSAGE = "El registro del empleado fue creado exitosamente.";

    //Un nombre de campo constante utilizado para la paginación.
    public static final String PAGEABLE_FIELD_NAME = "name";

}
