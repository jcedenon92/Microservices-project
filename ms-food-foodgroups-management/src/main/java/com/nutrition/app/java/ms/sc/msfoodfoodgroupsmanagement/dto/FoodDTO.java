package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

    private Integer id;
    private String name;
    private String description;
    private String energyK;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private FoodGroupsDTO foodGroups;
}
