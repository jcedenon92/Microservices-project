package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service;

import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.DoseDetailEntity;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.VaccineEntity;

import java.util.List;

public interface IVaccineService extends ICRUD<VaccineEntity, Integer> {

    VaccineEntity saveTransactional(VaccineEntity vaccine, List<DoseDetailEntity> details);

}
