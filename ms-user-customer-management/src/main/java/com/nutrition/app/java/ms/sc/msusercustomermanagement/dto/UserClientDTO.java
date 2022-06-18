package com.nutrition.app.java.ms.sc.msusercustomermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserClientDTO {

    private Integer idUser;
    private String firstName;
    private String lastName;
    private String surname;
    private String username;
    private String password;
    private List<RoleClientDTO> roles;
}
