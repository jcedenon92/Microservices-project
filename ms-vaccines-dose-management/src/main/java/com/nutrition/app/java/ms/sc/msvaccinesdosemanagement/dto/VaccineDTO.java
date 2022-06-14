package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDTO implements Serializable {

    private Long id;

    private String name;
}
