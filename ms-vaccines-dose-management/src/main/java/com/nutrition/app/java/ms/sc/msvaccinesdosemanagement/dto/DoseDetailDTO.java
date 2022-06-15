package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoseDetailDTO {

    private Integer idDosedetail;
    @JsonIgnore
    private VaccineDTO vaccine;
    private String month;
}
