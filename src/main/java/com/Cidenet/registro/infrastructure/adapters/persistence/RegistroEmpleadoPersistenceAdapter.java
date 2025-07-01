package com.Cidenet.registro.infrastructure.adapters.persistence;
import com.Cidenet.registro.domain.ports.out.RegistroEmpleadoPersistencePort;
import com.Cidenet.registro.commons.constans.Constants;
import com.Cidenet.registro.domain.models.RegistroEmpleadoModel;
import com.Cidenet.registro.infrastructure.entities.RegistroEmpleadoEntity;
import com.Cidenet.registro.infrastructure.mappers.RegistroEmpleadoEntityMapper;
import com.Cidenet.registro.infrastructure.repositories.mysql.RegistroEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistroEmpleadoPersistenceAdapter implements RegistroEmpleadoPersistencePort {
    private final RegistroEmpleadoRepository registroERepository;
    private final RegistroEmpleadoEntityMapper registroEEntityMapper;

    public RegistroEmpleadoPersistenceAdapter(RegistroEmpleadoRepository registroERepository,
                                              RegistroEmpleadoEntityMapper registroEEntityMapper) {
        this.registroERepository = registroERepository;
        this.registroEEntityMapper = registroEEntityMapper;
    }

    @Override
    public void save(RegistroEmpleadoModel registroEModel) {
        registroERepository.save(registroEEntityMapper.modelToEntity(registroEModel));
    }

    @Override
    public RegistroEmpleadoModel getRegistroEmpleadoByNumeroIdentificacion(String registroENumeroIdentificacion) {
        return registroEEntityMapper.entityToModel(registroERepository.findByNumeroIdentificacion(registroENumeroIdentificacion).orElse(null));
    }

    @Override
    public Page<RegistroEmpleadoModel> getRegistrosE(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        Page<RegistroEmpleadoEntity> entityPage = registroERepository.findAll(pagination);
        List<RegistroEmpleadoModel> modelList = registroEEntityMapper.entityListToModelList(entityPage.getContent());
        return new PageImpl<>(modelList, pagination, entityPage.getTotalElements());
    }
}

