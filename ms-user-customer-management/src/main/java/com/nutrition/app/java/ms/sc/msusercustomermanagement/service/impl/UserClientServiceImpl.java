package com.nutrition.app.java.ms.sc.msusercustomermanagement.service.impl;

import com.nutrition.app.java.ms.sc.msusercustomermanagement.entity.UserClientEntity;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.repository.IGenericRepo;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.repository.IUserClientRepo;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.service.IUserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClientServiceImpl extends CRUDImpl<UserClientEntity, Integer> implements IUserClientService {

    @Autowired
    private IUserClientRepo userClientRepo;

    @Override
    protected IGenericRepo<UserClientEntity, Integer> getRepository() {
        return userClientRepo;
    }
}
