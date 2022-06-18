package com.nutrition.app.java.ms.sc.msusercustomermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleClientDTO {

    private Integer idRole;
    private String name;
    private String description;
    private boolean status;
}
