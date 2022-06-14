package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service;

import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

    List<T> findByLike(T t) throws ServiceException;

    Optional<T> findById(Long id) throws ServiceException;

    Optional<T> create(T t) throws ServiceException;
}
