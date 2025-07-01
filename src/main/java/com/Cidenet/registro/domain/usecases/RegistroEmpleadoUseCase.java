package com.Cidenet.registro.domain.usecases;

import com.Cidenet.registro.domain.exceptions.RegistroEmpleadoAlreadyExistsException;
import com.Cidenet.registro.domain.models.RegistroEmpleadoModel;
import com.Cidenet.registro.domain.ports.in.RegistroEmpleadoServicePort;
import com.Cidenet.registro.domain.ports.out.RegistroEmpleadoPersistencePort;
import org.springframework.data.domain.Page;

public class RegistroEmpleadoUseCase implements RegistroEmpleadoServicePort {
    private final RegistroEmpleadoPersistencePort registroEPersistencePort;



    public RegistroEmpleadoUseCase(RegistroEmpleadoPersistencePort registroEPersistencePort) {
        this.registroEPersistencePort = registroEPersistencePort;
    }

    @Override
    public void save(RegistroEmpleadoModel registroEModel) {
        RegistroEmpleadoModel registroE = registroEPersistencePort.getRegistroEmpleadoByNumeroIdentificacion(registroEModel.getNumeroIdentificacion());

        if (registroE != null) {
            throw new RegistroEmpleadoAlreadyExistsException("Ya existe un registro de empleado con el mismo número de identificación");
        }
        registroEPersistencePort.save(registroEModel);
    }

    @Override
    public Page<RegistroEmpleadoModel> getRegistrosE(Integer page, Integer size, boolean orderAsc) {
        return registroEPersistencePort.getRegistrosE(page, size, orderAsc);
    }
}

