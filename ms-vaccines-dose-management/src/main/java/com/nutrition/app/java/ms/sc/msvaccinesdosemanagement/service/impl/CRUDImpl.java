package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.impl;

import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.repository.IGenericRepository;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepository<T, ID> getRepository();

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
