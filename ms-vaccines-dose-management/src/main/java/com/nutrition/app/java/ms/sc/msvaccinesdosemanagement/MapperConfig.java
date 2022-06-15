package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement;

import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.dto.VaccineDTO;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.VaccineEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("vaccineMapper")
    public ModelMapper vaccineMapper(){
        ModelMapper mapper = new ModelMapper();
        TypeMap<VaccineDTO, VaccineEntity> typeMap = mapper.createTypeMap(VaccineDTO.class, VaccineEntity.class);
        typeMap.addMapping(VaccineDTO::getId, VaccineEntity::setIdVaccine);
        typeMap.addMapping(VaccineDTO::getName, VaccineEntity::setName);
        typeMap.addMapping(VaccineDTO::getDescription, VaccineEntity::setDescription);
        typeMap.addMapping(VaccineDTO::isStatus, VaccineEntity::setStatus);
        typeMap.addMapping(VaccineDTO::getCreatedAt, VaccineEntity::setCreatedAt);
        typeMap.addMapping(VaccineDTO::getUpdatedAt, VaccineEntity::setUpdatedAt);
        typeMap.addMapping(VaccineDTO::getDoseDetails, VaccineEntity::setDoseDetails);
        return new ModelMapper();
    }
}
