package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.service;

import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodEntity;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodGroupsEntity;

public interface IFoodService extends ICRUD<FoodEntity, Integer>{

    FoodEntity saveTransactional(FoodEntity food, FoodGroupsEntity foodGroups) throws Exception;
}
