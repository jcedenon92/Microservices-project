package com.nutrition.app.java.ms.sc.msusercustomermanagement.controller;

import com.nutrition.app.java.ms.sc.msusercustomermanagement.dto.RoleClientDTO;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.entity.RoleClientEntity;
import com.nutrition.app.java.ms.sc.msusercustomermanagement.service.IRoleClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.nutrition.app.java.ms.sc.msusercustomermanagement.commons.GlobalConstants.*;

@RestController
@RequestMapping(API_ROLES)
public class RoleClientController {

    @Autowired
    private IRoleClientService roleClientService;

    @Autowired
    @Qualifier("roleClientMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Response> readAll() throws Exception{
        List<RoleClientDTO> list = roleClientService.getAll().stream()
                .map( v -> mapper.map(v, RoleClientDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(Response
                .builder()
                .message(Message.builder()
                        .code(COD_ROLE_OBTAINED)
                        .message(MSG_ROLE_OBTAINED)
                        .build())
                .data(list)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") Integer id) throws Exception{
        RoleClientEntity role = roleClientService.getById(id);
//        if (role == null){
//            throw new ModelNotFoundException("ID NOT FOUND: " + id);
//        }
        RoleClientDTO dto = mapper.map(role, RoleClientDTO.class);
        return new ResponseEntity<>(Response
                .builder()
                .message(Message.builder()
                        .code(COD_ROLE_OBTAINED)
                        .message(MSG_ROLE_OBTAINED)
                        .build())
                .data(dto)
                .build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody RoleClientDTO dto) throws Exception{
        RoleClientEntity role = roleClientService.create(mapper.map(dto, RoleClientEntity.class));
        dto = mapper.map(role, RoleClientDTO.class);
        return new ResponseEntity<>(Response
                .builder()
                .message(Message.builder()
                        .code(COD_ROLE_CREATED)
                        .message(MSG_ROLE_CREATED)
                        .build())
                .data(dto)
                .build(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Response> update(@Valid @RequestBody RoleClientDTO roleClientDTO) throws Exception{
        RoleClientEntity role = roleClientService.update(mapper.map(roleClientDTO, RoleClientEntity.class));
        RoleClientDTO dto = mapper.map(role, RoleClientDTO.class);
        return new ResponseEntity<>(Response
                .builder()
                .message(Message.builder()
                        .code(COD_ROLE_UPDATED)
                        .message(MSG_ROLE_UPDATED)
                        .build())
                .data(dto)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Integer id) throws Exception{
        roleClientService.delete(id);
        RoleClientDTO dto = mapper.map(roleClientService.getById(id), RoleClientDTO.class);
        return new ResponseEntity<>(Response
                .builder()
                .message(Message.builder()
                        .code(COD_ROLE_DELETED)
                        .message(MSG_ROLE_DELETED)
                        .build())
                .data(dto)
                .build(), HttpStatus.OK);
    }
}
