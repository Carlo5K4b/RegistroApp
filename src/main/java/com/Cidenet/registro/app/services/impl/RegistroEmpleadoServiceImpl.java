package com.Cidenet.registro.app.services.impl;
import com.Cidenet.registro.app.dto.request.RegistroEmpleadoRequest;
import com.Cidenet.registro.app.dto.response.RegistroEmpleadoResponse;
import com.Cidenet.registro.app.dto.response.SaveRegistroEmpleadoResponse;
import com.Cidenet.registro.app.mappers.RegistroEmpleadoDtoMapper;
import com.Cidenet.registro.app.services.RegistroEmpleadoService;
import com.Cidenet.registro.domain.models.RegistroEmpleadoModel;
import com.Cidenet.registro.domain.ports.in.RegistroEmpleadoServicePort;
import com.Cidenet.registro.commons.constans.Constants;
import com.Cidenet.registro.infrastructure.mappers.RegistroEmpleadoEntityMapper;
import com.Cidenet.registro.infrastructure.repositories.mysql.RegistroEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class RegistroEmpleadoServiceImpl implements RegistroEmpleadoService {
    private final RegistroEmpleadoServicePort registroEServicePort;
    private final RegistroEmpleadoDtoMapper registroEDtoMapper;
    private final RegistroEmpleadoRepository registroERepository;

    public RegistroEmpleadoServiceImpl(RegistroEmpleadoServicePort registroEServicePort, RegistroEmpleadoDtoMapper registroEDtoMapper, RegistroEmpleadoRepository registroERepository) {
        this.registroEServicePort = registroEServicePort;
        this.registroEDtoMapper = registroEDtoMapper;
        this.registroERepository = registroERepository;
    }

    private String generarCorreo(String nombre, String apellido1, String pais) {
        String dominio = pais.equalsIgnoreCase("COLOMBIA") ? "cidenet.com.co" : "cidenet.com.us";
        String correoBase = nombre.toLowerCase() + "." + apellido1.toLowerCase().replaceAll("\\s+", "") + "@" + dominio;
        String correo = correoBase;
        int secuencia = 1;
        while (registroERepository.findByCorreo(correo).isPresent()) {
            correo = nombre.toLowerCase() + "." + apellido1.toLowerCase().replaceAll("\\s+", "") + "." + secuencia + "@" + dominio;
            secuencia++;
        }
        return correo;
    }

    private String generarSiguienteId(String ultimoNumId) {
        // Lógica para generar el siguiente ID alfanumérico
        // Ejemplo simple: incrementar un número, o usar UUID
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

    @Override
    public SaveRegistroEmpleadoResponse save(RegistroEmpleadoRequest request) {
        RegistroEmpleadoModel registroEModel = registroEDtoMapper.requestToModel(request);

        // Validar que fecha de ingreso no sea superior a la fecha actual ni menor a un mes antes de hoy
        LocalDate fechaIngreso = LocalDate.parse(request.fechaIngreso());
        LocalDate hoy = LocalDate.now();

        if (fechaIngreso.isAfter(hoy) || fechaIngreso.isBefore(hoy.minus(1, ChronoUnit.MONTHS))) {
            throw new IllegalArgumentException("La fecha de ingreso no puede ser superior a la fecha actual ni menor a un mes antes de hoy.");
        }

        // Validar si el número de identificación ya existe
        String numeroIdentificacion;
        do {
            numeroIdentificacion = generarSiguienteId(null);
        } while (registroERepository.findByNumeroIdentificacion(numeroIdentificacion).isPresent());

        // Obtener primer nombre y primer apellido compuesto
        String nombre = request.nombre();
        String apellido1 = request.apellido1().replaceAll("\\s+", "");
        String pais = request.pais();

        String correo = generarCorreo(nombre, apellido1, pais);

        registroEModel.setNumeroIdentificacion(numeroIdentificacion);
        registroEModel.setCorreo(correo);

        registroEServicePort.save(registroEModel);

        return new SaveRegistroEmpleadoResponse(Constants.SAVE_REGISTROEMPLEADO_RESPONSE_MESSAGE, LocalDateTime.now());
    }


    @Override
    public Page<RegistroEmpleadoResponse> getRegistrosE(Integer page, Integer size, boolean orderAsc) {
        Page<RegistroEmpleadoModel> registroEModelMyPages = registroEServicePort.getRegistrosE(page, size, orderAsc);
        List<RegistroEmpleadoResponse> registroEResponses = registroEDtoMapper.modelListToResponseList(registroEModelMyPages.getContent());
        return new PageImpl<>(registroEResponses, PageRequest.of(page, size), registroEModelMyPages.getTotalElements());
    }
}
