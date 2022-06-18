package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.controller;

import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.dto.FoodGroupsDTO;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodGroupsEntity;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.exceptions.ModelNotFoundException;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.service.IFoodGroupsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.commons.GlobalConstants.*;

@RestController
@RequestMapping(API_FOOD_GROUPS)
public class FoodGroupsController {

    @Autowired
    private IFoodGroupsService foodGroupsService;

    @Autowired
    @Qualifier("foodGroupsMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Response> getAll() throws Exception{
        List<FoodGroupsDTO> list = foodGroupsService.getAll().stream()
                .map(f -> mapper.map(f, FoodGroupsDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(Response
                                    .builder()
                                    .message(Message.builder()
                                            .code(COD_FOOD_GROUPS_OBTAINED)
                                            .message(MSG_FOOD_GROUPS_OBTAINED)
                                            .build())
                                    .data(list)
                                    .build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") Integer id) throws Exception{
        FoodGroupsEntity foodGroups = foodGroupsService.getById(id);
        if (foodGroups == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        FoodGroupsDTO dto = mapper.map(foodGroups, FoodGroupsDTO.class);
        return new ResponseEntity<>(Response
                                    .builder()
                                    .message(Message.builder()
                                            .code(COD_FOOD_GROUPS_OBTAINED)
                                            .message(MSG_FOOD_GROUPS_OBTAINED)
                                            .build())
                                    .data(dto)
                                    .build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody FoodGroupsDTO foodGroupsDTO) throws Exception{
        FoodGroupsEntity foodGroups = foodGroupsService.create(mapper.map(foodGroupsDTO, FoodGroupsEntity.class));
        FoodGroupsDTO dto = mapper.map(foodGroups, FoodGroupsDTO.class);
        return new ResponseEntity<>(Response
                                    .builder()
                                    .message(Message.builder()
                                            .code(COD_FOOD_GROUPS_CREATED)
                                            .message(MSG_FOOD_GROUPS_CREATED)
                                            .build())
                                    .data(dto)
                                    .build(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Response> update(@RequestBody FoodGroupsDTO foodGroupsDTO) throws Exception{
        FoodGroupsEntity foodGroups = foodGroupsService.getById(foodGroupsDTO.getId());
        if (foodGroups == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + foodGroupsDTO.getId());
        }
        FoodGroupsEntity f = foodGroupsService.update(mapper.map(foodGroupsDTO, FoodGroupsEntity.class));
        FoodGroupsDTO dto = mapper.map(f, FoodGroupsDTO.class);
        return new ResponseEntity<>(Response
                                    .builder()
                                    .message(Message.builder()
                                            .code(COD_FOOD_GROUPS_UPDATED)
                                            .message(MSG_FOOD_GROUPS_UPDATED)
                                            .build())
                                    .data(dto)
                                    .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Integer id) throws Exception{
        FoodGroupsEntity foodGroups = foodGroupsService.getById(id);
        if (foodGroups == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        foodGroupsService.delete(id);
        FoodGroupsDTO dto = mapper.map(foodGroups, FoodGroupsDTO.class);
        return new ResponseEntity<>(Response
                                    .builder()
                                    .message(Message.builder()
                                            .code(COD_FOOD_GROUPS_DELETED)
                                            .message(MSG_FOOD_GROUPS_DELETED)
                                            .build())
                                    .data(dto)
                                    .build(), HttpStatus.OK);
    }

}














