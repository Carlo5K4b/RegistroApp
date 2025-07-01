package com.Cidenet.registro.infrastructure.repositories.mysql;

import com.Cidenet.registro.infrastructure.entities.RegistroEmpleadoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RegistroEmpleadoRepository extends JpaRepository<RegistroEmpleadoEntity, String> {

    Optional<RegistroEmpleadoEntity> findByNumeroIdentificacion(String numeroIdentificacion);

    Optional<RegistroEmpleadoEntity> findByCorreo(String correo);

    Page<RegistroEmpleadoEntity> findAll(Pageable pageable);
}
