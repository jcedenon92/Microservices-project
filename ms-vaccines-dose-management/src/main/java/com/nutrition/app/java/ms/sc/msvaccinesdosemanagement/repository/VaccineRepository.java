package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.repository;

import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.VaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineEntity, Long>{
}
