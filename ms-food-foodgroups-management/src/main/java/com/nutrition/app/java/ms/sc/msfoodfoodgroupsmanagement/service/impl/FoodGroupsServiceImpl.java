package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.service.impl;

import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodGroupsEntity;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.repository.IFoodGroupsRepo;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.repository.IGenericRepo;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.service.IFoodGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodGroupsServiceImpl extends CRUDImpl<FoodGroupsEntity, Integer> implements IFoodGroupsService {

    @Autowired
    private IFoodGroupsRepo foodGroupsRepo;

    @Override
    protected IGenericRepo<FoodGroupsEntity, Integer> getRepo() {
        return foodGroupsRepo;
    }
}
