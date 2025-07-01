package com.Cidenet.registro.app.services;
import com.Cidenet.registro.app.dto.request.RegistroEmpleadoRequest;
import com.Cidenet.registro.app.dto.response.RegistroEmpleadoResponse;
import com.Cidenet.registro.app.dto.response.SaveRegistroEmpleadoResponse;
import org.springframework.data.domain.Page;

public interface RegistroEmpleadoService {

    SaveRegistroEmpleadoResponse save(RegistroEmpleadoRequest request);

    Page<RegistroEmpleadoResponse> getRegistrosE(Integer page, Integer size, boolean orderAsc);
}


