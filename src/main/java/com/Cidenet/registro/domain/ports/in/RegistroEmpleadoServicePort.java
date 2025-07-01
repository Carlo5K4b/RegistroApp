package com.Cidenet.registro.domain.ports.in;

import com.Cidenet.registro.domain.models.RegistroEmpleadoModel;
import org.springframework.data.domain.Page;

public interface RegistroEmpleadoServicePort {

    void save(RegistroEmpleadoModel registroEModel);

    Page<RegistroEmpleadoModel> getRegistrosE(Integer page, Integer size, boolean orderAsc);

}
