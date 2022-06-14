package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.impl;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.dto.VaccineDTO;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.VaccineEntity;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.repository.VaccineRepository;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.VaccineService;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineServiceImpl implements VaccineService {

    private JsonMapper jsonMapper;
    private VaccineRepository vaccineRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository, JsonMapper jsonMapper) {
        super();
        this.vaccineRepository = vaccineRepository;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<VaccineDTO> findByLike(VaccineDTO vaccineDTO) throws ServiceException {
        try {
            List<VaccineEntity> lstVaccineEntity = vaccineRepository.findAll();
            return lstVaccineEntity.stream()
                    .map(this::getVaccineDTO).collect(Collectors.toList());
        }catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Optional<VaccineDTO> findById(Long id) throws ServiceException {
        try {
            Optional<VaccineEntity> vaccineEntity = vaccineRepository.findById(id);
            return vaccineEntity.map(this::getVaccineDTO);
        }catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Optional<VaccineDTO> create(VaccineDTO vaccineDTO) throws ServiceException {
        VaccineEntity vaccineEntity = vaccineRepository.save(getVaccineEntity(vaccineDTO));
        return Optional.of(getVaccineDTO(vaccineEntity));
    }

    //Mappers
    private VaccineDTO getVaccineDTO(VaccineEntity vaccineEntity){
        return jsonMapper.convertValue(vaccineEntity, VaccineDTO.class);
    }

    private VaccineEntity getVaccineEntity(VaccineDTO vaccineDTO){
        return jsonMapper.convertValue(vaccineDTO, VaccineEntity.class);
    }



}
