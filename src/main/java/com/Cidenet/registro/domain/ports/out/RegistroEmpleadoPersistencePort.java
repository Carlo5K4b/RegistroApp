package com.Cidenet.registro.domain.ports.out;

import com.Cidenet.registro.domain.models.RegistroEmpleadoModel;
import org.springframework.data.domain.Page;

public interface RegistroEmpleadoPersistencePort {
    void save(RegistroEmpleadoModel registroEModel);

    RegistroEmpleadoModel getRegistroEmpleadoByNumeroIdentificacion(String registroENumeroIdentificacion);

    Page<RegistroEmpleadoModel> getRegistrosE(Integer page, Integer size, boolean orderAsc);

}
