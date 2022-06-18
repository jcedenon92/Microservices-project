package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.impl;

import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.DoseDetailEntity;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.VaccineEntity;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.repository.IGenericRepository;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.repository.IVaccineRepository;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl extends CRUDImpl<VaccineEntity, Integer> implements IVaccineService {

    @Autowired
    private IVaccineRepository vaccineRepository;

    @Override
    protected IGenericRepository<VaccineEntity, Integer> getRepository() {
        return vaccineRepository;
    }

    @Override
    public VaccineEntity saveTransactional(VaccineEntity vaccine, List<DoseDetailEntity> details) throws Exception {
        details.forEach(d -> d.setVaccine(vaccine));
        vaccine.setDoseDetails(details);

        return vaccineRepository.save(vaccine);
    }

    @Override
    public VaccineEntity updateTransactional(VaccineEntity vaccine, List<DoseDetailEntity> details) throws Exception {
        details.forEach(d -> d.setVaccine(vaccine));
        vaccine.setDoseDetails(details);

        return vaccineRepository.save(vaccine);
    }
}
