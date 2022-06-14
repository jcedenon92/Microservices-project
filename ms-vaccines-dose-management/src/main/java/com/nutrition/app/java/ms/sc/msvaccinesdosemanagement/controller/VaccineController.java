package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.controller;

import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.dto.VaccineDTO;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.VaccineEntity;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.VaccineService;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vaccines")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping
    public ResponseEntity<List<VaccineDTO>> findAll(VaccineDTO vaccineDTO) throws ServiceException {
        List<VaccineDTO> lstVaccineEntity = vaccineService.findByLike(vaccineDTO);
        return new ResponseEntity<>(lstVaccineEntity, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaccineDTO> findById(@PathVariable("id") Long id) throws ServiceException {
        Optional<VaccineDTO> vaccineEntity = vaccineService.findById(id);

        return new ResponseEntity<>(vaccineEntity.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VaccineDTO> create(@RequestBody VaccineDTO vaccineDTO) throws ServiceException{
        Optional<VaccineDTO> vaccineEntity = vaccineService.create(vaccineDTO);
        return new ResponseEntity<>(vaccineEntity.get(), HttpStatus.CREATED);
    }
}
