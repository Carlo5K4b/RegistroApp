package com.Cidenet.registro.app.mappers;

import com.Cidenet.registro.app.dto.request.RegistroEmpleadoRequest;
import com.Cidenet.registro.app.dto.response.RegistroEmpleadoResponse;
import com.Cidenet.registro.domain.models.RegistroEmpleadoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)


public interface RegistroEmpleadoDtoMapper {
    RegistroEmpleadoModel requestToModel(RegistroEmpleadoRequest registroERequest);

    RegistroEmpleadoResponse modelToResponse(RegistroEmpleadoModel registroEModel);

    List<RegistroEmpleadoResponse> modelListToResponseList(List<RegistroEmpleadoModel> registroEmpleados);
}
