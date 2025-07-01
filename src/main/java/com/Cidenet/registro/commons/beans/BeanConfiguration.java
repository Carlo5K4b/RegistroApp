package com.Cidenet.registro.commons.beans;

import com.Cidenet.registro.domain.ports.in.RegistroEmpleadoServicePort;
import com.Cidenet.registro.domain.ports.out.RegistroEmpleadoPersistencePort;
import com.Cidenet.registro.domain.usecases.RegistroEmpleadoUseCase;
import com.Cidenet.registro.infrastructure.adapters.persistence.RegistroEmpleadoPersistenceAdapter;
import com.Cidenet.registro.infrastructure.mappers.RegistroEmpleadoEntityMapper;
import com.Cidenet.registro.infrastructure.repositories.mysql.RegistroEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {

    private final RegistroEmpleadoRepository registroERepository;
    private final RegistroEmpleadoEntityMapper registroEEntityMapper;

    public BeanConfiguration(RegistroEmpleadoRepository registroERepository,
                             RegistroEmpleadoEntityMapper registroEEntityMapper) {
        this.registroERepository = registroERepository;
        this.registroEEntityMapper = registroEEntityMapper;
    }

    @Bean
    public RegistroEmpleadoServicePort registroEServicePort() {
        return new RegistroEmpleadoUseCase(registroEPersistencePort());
    }

    @Bean
    public RegistroEmpleadoPersistencePort registroEPersistencePort() {
        return new RegistroEmpleadoPersistenceAdapter(registroERepository, registroEEntityMapper);
    }


}


