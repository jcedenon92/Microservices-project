package com.nutrition.app.java.ms.sc.msusercustomermanagement.service.impl;

import com.nutrition.app.java.ms.sc.msusercustomermanagement.entity.UserClientEntity;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.repository.IGenericRepo;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepository();

    @Override
    public T create(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T update(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public List<T> getAll() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public T getById(ID id) throws Exception {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepository().deleteById(id);
    }
}
