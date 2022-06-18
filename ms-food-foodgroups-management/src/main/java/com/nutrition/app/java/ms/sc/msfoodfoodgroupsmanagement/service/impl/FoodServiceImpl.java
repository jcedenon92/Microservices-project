package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.service.impl;

import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodEntity;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodGroupsEntity;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.repository.IFoodRepo;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.repository.IGenericRepo;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl extends CRUDImpl<FoodEntity, Integer> implements IFoodService {

    @Autowired
    private IFoodRepo foodRepo;
    @Override
    protected IGenericRepo<FoodEntity, Integer> getRepo() {
        return foodRepo;
    }

    @Override
    public FoodEntity saveTransactional(FoodEntity food, FoodGroupsEntity foodGroups) throws Exception {
        food.setFoodGroups(foodGroups);
        return foodRepo.save(food);
    }
}
