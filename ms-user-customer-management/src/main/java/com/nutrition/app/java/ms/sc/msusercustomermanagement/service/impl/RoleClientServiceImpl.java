package com.nutrition.app.java.ms.sc.msusercustomermanagement.service.impl;

import com.nutrition.app.java.ms.sc.msusercustomermanagement.entity.RoleClientEntity;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.repository.IGenericRepo;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.repository.IRoleClientRepo;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.service.IRoleClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleClientServiceImpl extends CRUDImpl<RoleClientEntity, Integer> implements IRoleClientService {

    @Autowired
    private IRoleClientRepo roleClientRepo;

    @Override
    protected IGenericRepo<RoleClientEntity, Integer> getRepository() {
        return roleClientRepo;
    }
}
