package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement;

import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.dto.FoodDTO;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.dto.FoodGroupsDTO;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodEntity;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodGroupsEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {

    @Primary
    @Bean("foodGroupsMapper")
    public ModelMapper foodGroupsMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<FoodGroupsDTO, FoodGroupsEntity> typeMap = mapper.createTypeMap(FoodGroupsDTO.class, FoodGroupsEntity.class);
        typeMap.addMapping(FoodGroupsDTO::getId, FoodGroupsEntity::setIdFoodgroups);
        typeMap.addMapping(FoodGroupsDTO::getName, FoodGroupsEntity::setName);
        typeMap.addMapping(FoodGroupsDTO::getDescription, FoodGroupsEntity::setDescription);
        typeMap.addMapping(FoodGroupsDTO::isStatus, FoodGroupsEntity::setStatus);
        return new ModelMapper();
    }

    @Bean("foodsMapper")
    public ModelMapper foodsMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<FoodDTO, FoodEntity> typeMap = mapper.createTypeMap(FoodDTO.class, FoodEntity.class);
        typeMap.addMapping(FoodDTO::getId, FoodEntity::setIdFood);
        typeMap.addMapping(FoodDTO::getName, FoodEntity::setName);
        typeMap.addMapping(FoodDTO::getDescription, FoodEntity::setDescription);
        typeMap.addMapping(FoodDTO::getEnergyK, FoodEntity::setEnergyKcal);
        typeMap.addMapping(FoodDTO::getCreatedAt, FoodEntity::setCreatedAt);
        typeMap.addMapping(FoodDTO::getUpdatedAt, FoodEntity::setUpdatedAt);
//        typeMap.addMapping(FoodDTO::getGroups, FoodEntity::setFoodGroups);
        typeMap.addMapping(FoodDTO::getFoodGroups, (dest,v) -> dest.getFoodGroups().setIdFoodgroups((Integer)v));
        return new ModelMapper();
    }


}
