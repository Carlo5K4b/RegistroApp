
package com.Cidenet.registro.domain.usecases;

import com.Cidenet.registro.domain.exceptions.RegistroEmpleadoAlreadyExistsException;
import com.Cidenet.registro.domain.models.RegistroEmpleadoModel;
import com.Cidenet.registro.domain.ports.out.RegistroEmpleadoPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class RegistroEmpleadoUseCaseTest {


    @Mock
    private RegistroEmpleadoPersistencePort registroEPersistencePort;

    @InjectMocks
    private RegistroEmpleadoUseCase registroEUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveRegistroEmpleadoSuccessfully() {
        RegistroEmpleadoModel registroEModel = new RegistroEmpleadoModel("NOMBRE","OTROSNOMBRES"
                ,"APELLIDO1", "APELLIDO2","PAIS", "TIPOIDENTIFICACION",  "NUMEROIDENTIFICACION"
                ,"correo@dominio.com", "2024-06-01", "AREA", "ACTIVO", "2024-06-01T10:00");
        when(registroEPersistencePort.getRegistroEmpleadoByNumeroIdentificacion(registroEModel.getNumeroIdentificacion())).thenReturn(null);

        registroEUseCase.save(registroEModel);

        verify(registroEPersistencePort, times(1)).save(registroEModel);
    }

    @Test
    void testSaveRegistroEmpleadoAlreadyExists() {
        RegistroEmpleadoModel registroEModel = new RegistroEmpleadoModel("NOMBRE","OTROSNOMBRES"
                ,"APELLIDO1", "APELLIDO2","PAIS", "TIPOIDENTIFICACION",  "NUMEROIDENTIFICACION"
                ,"correo@dominio.com", "2024-06-01", "AREA", "ACTIVO", "2024-06-01T10:00");
        when(registroEPersistencePort.getRegistroEmpleadoByNumeroIdentificacion(registroEModel.getNumeroIdentificacion())).thenReturn(registroEModel);

        assertThrows(RegistroEmpleadoAlreadyExistsException.class, () -> registroEUseCase.save(registroEModel));

        verify(registroEPersistencePort, never()).save(registroEModel);
    }

    @Test
    void testGetRegistroEmpleados() {
        int page = 0;
        int size = 10;
        boolean orderAsc = true;
        long totalElements = 2;

        List<RegistroEmpleadoModel> registrosE = Arrays.asList(
                new RegistroEmpleadoModel("NOMBRE","OTROSNOMBRES"
                        ,"APELLIDO1", "APELLIDO2","PAIS", "TIPOIDENTIFICACION",  "NUMEROIDENTIFICACION"
                        ,"correo@dominio.com", "2024-06-01", "AREA", "ACTIVO", "2024-06-01T10:00"),
                new RegistroEmpleadoModel("NOMBRE","OTROSNOMBRES"
                        ,"APELLIDO1", "APELLIDO2","PAIS", "TIPOIDENTIFICACION",  "NUMEROIDENTIFICACION"
                        ,"correo@dominio.com", "2024-06-01", "AREA", "ACTIVO", "2024-06-01T10:00")
        );
        Page<RegistroEmpleadoModel> expectedPage = new PageImpl<>(registrosE, PageRequest.of(page, size), totalElements);
        when(registroEPersistencePort.getRegistrosE(page, size, orderAsc)).thenReturn(expectedPage);

        Page<RegistroEmpleadoModel> result = registroEUseCase.getRegistrosE(page, size, orderAsc);

        assertEquals(expectedPage, result);
        verify(registroEPersistencePort, times(1)).getRegistrosE(page, size, orderAsc);
    }
}