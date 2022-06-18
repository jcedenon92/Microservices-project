package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodGroupsDTO {

    private Integer id;

    @NotNull(message = "Food group name is required")
    @Size(min = 3, max = 250, message = "Food group name must be between 3 and 200 characters")
    private String name;

    @NotNull(message = "Food group description is required")
    @Size(min = 3, max = 250, message = "Food group description must be between 3 and 250 characters")
    private String description;

    @NotNull(message = "Food group status is required")
    private boolean status;
}
