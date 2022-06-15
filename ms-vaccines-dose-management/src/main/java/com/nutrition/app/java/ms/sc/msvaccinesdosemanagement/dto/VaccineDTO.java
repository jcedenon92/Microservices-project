package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccineDTO{

    private Integer id;

    @NotNull(message = "Vaccine name is required")
    @Size(min = 3, max = 200, message = "Vaccine name must be between 3 and 200 characters")
    private String name;

    @NotNull(message = "Vaccine description is required")
    @Size(min = 3, max = 250, message = "Vaccine description must be between 3 and 250 characters")
    private String description;

    @NotNull(message = "Vaccine status is required")
    private boolean status;

    @NotNull(message = "Vaccine created at is required")
    private LocalDateTime createdAt;

    @NotNull(message = "Vaccine updated at is required")
    private LocalDateTime updatedAt;

//    @NotNull(message = "Vaccine dose details is required")
    private List<DoseDetailDTO> doseDetails;
}
