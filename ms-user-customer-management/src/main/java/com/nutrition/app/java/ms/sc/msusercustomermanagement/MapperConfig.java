package com.nutrition.app.java.ms.sc.msusercustomermanagement;

import com.nutrition.app.java.ms.sc.msusercustomermanagement.dto.RoleClientDTO;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.entity.RoleClientEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("roleClientMapper")
    public ModelMapper roleMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<RoleClientDTO, RoleClientEntity> typeMap = mapper.createTypeMap(RoleClientDTO.class, RoleClientEntity.class);
        typeMap.addMapping(RoleClientDTO::getIdRole, RoleClientEntity::setIdRoleClient);
        typeMap.addMapping(RoleClientDTO::getName, RoleClientEntity::setName);
        typeMap.addMapping(RoleClientDTO::getDescription, RoleClientEntity::setDescription);
        typeMap.addMapping(RoleClientDTO::isStatus, RoleClientEntity::setStatus);
        return new ModelMapper();
    }

}
