package com.Cidenet.registro.infrastructure.mappers;

import com.Cidenet.registro.domain.models.RegistroEmpleadoModel;
import com.Cidenet.registro.infrastructure.entities.RegistroEmpleadoEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistroEmpleadoEntityMapper {
    //Convierte un objeto
    RegistroEmpleadoEntity modelToEntity(RegistroEmpleadoModel registroEModel);

    RegistroEmpleadoModel entityToModel(RegistroEmpleadoEntity registroEEntity);

    //Convierte una lista de objetos
    List<RegistroEmpleadoModel> entityListToModelList(List<RegistroEmpleadoEntity> registrosE);
}

