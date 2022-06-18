package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.controller;

import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.dto.FoodDTO;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.dto.FoodGroupsDTO;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodEntity;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity.FoodGroupsEntity;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.exceptions.ModelNotFoundException;
import com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.service.IFoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.commons.GlobalConstants.*;

@RestController
@RequestMapping(API_FOODS)
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @Autowired
    @Qualifier("foodsMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Response> getAll() throws Exception{
        List<FoodDTO> list = foodService.getAll().stream()
                .map(f -> mapper.map(f, FoodDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(Response
                .builder()
                .message(Message.builder()
                        .code(COD_FOODS_OBTAINED)
                        .message(MSG_FOODS_OBTAINED)
                        .build())
                .data(list)
                .build(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody FoodDTO foodDTO) throws Exception{
//        FoodEntity food = mapper.map(foodDTO, FoodEntity.class);
//        FoodGroupsEntity foodGroupsEntity = mapper.map(foodGroupsDTO, FoodGroupsEntity .class);
//        FoodEntity f = foodService.saveTransactional(food, foodGroupsEntity);
        FoodEntity f = foodService.create(mapper.map(foodDTO, FoodEntity.class));
        FoodDTO dto = mapper.map(f, FoodDTO.class);
        return new ResponseEntity<>(Response
                .builder()
                .message(Message.builder()
                        .code(COD_FOODS_CREATED)
                        .message(MSG_FOODS_CREATED)
                        .build())
                .data(dto)
                .build(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Response> update(@RequestBody FoodDTO foodDTO) throws Exception{
        FoodEntity foodId = foodService.getById(foodDTO.getId());
        if (foodId == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + foodDTO.getId());
        }
        FoodEntity f = foodService.update(mapper.map(foodDTO, FoodEntity.class));
        FoodDTO dto = mapper.map(f, FoodDTO.class);
        return new ResponseEntity<>(Response
                .builder()
                .message(Message.builder()
                        .code(COD_FOODS_UPDATED)
                        .message(MSG_FOODS_UPDATED)
                        .build())
                .data(dto)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Integer id) throws Exception{
        FoodEntity foodId = foodService.getById(id);
        if (foodId == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        foodService.delete(id);
        FoodDTO dto = mapper.map(foodId, FoodDTO.class);
        return new ResponseEntity<>(Response
                .builder()
                .message(Message.builder()
                        .code(COD_FOODS_DELETED)
                        .message(MSG_FOODS_DELETED)
                        .build())
                .data(dto)
                .build(), HttpStatus.OK);
    }
}






