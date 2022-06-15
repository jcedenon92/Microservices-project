package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.repository;

import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.VaccineEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineRepository extends IGenericRepository<VaccineEntity, Integer>{
}
