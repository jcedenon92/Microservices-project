package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.controller;

import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.dto.VaccineDTO;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity.VaccineEntity;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.exceptions.ModelNotFoundException;
import com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.service.IVaccineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vaccines")
public class VaccineController {

    @Autowired
    private IVaccineService vaccineService;

    @Autowired
    @Qualifier("vaccineMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<VaccineDTO>> readAll() throws Exception{
        List<VaccineDTO> list = vaccineService.getAll().stream()
                .map( v -> mapper.map(v, VaccineDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //GetMapping("/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<VaccineDTO> getById(@PathVariable("id") Integer id) throws Exception{
        VaccineEntity vaccine = vaccineService.getById(id);
        if (vaccine == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        VaccineDTO dto = mapper.map(vaccine, VaccineDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VaccineDTO> create(@Valid @RequestBody VaccineDTO vaccineDTO) throws Exception{
        VaccineEntity v = mapper.map(vaccineDTO, VaccineEntity.class);
        VaccineEntity vac = vaccineService.saveTransactional(v, v.getDoseDetails());
        VaccineDTO dto = mapper.map(vac, VaccineDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<VaccineDTO> update(@Valid @RequestBody VaccineDTO vaccineDTO) throws Exception {
        VaccineEntity vac = vaccineService.getById(vaccineDTO.getId());
        if (vac == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + vaccineDTO.getId());
        }
        VaccineEntity v = vaccineService.saveTransactional(mapper.map(vaccineDTO, VaccineEntity.class), vac.getDoseDetails());
        VaccineDTO dto = mapper.map(v, VaccineDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VaccineDTO> delete(@PathVariable("id") Integer id) throws Exception{
        VaccineEntity vac = vaccineService.getById(id);
        if (vac == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        vaccineService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




















