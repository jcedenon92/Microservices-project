package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity;

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
@Entity
@Table(name = "vaccine")
public class VaccineEntity implements Serializable {

    @Id
    @Column(name = "id_vaccine")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Vaccine name is required")
    @Size(min = 3, max = 200, message = "Vaccine name must be between 3 and 50 characters")
    @Column(name = "name", nullable = false)
    private String name;
}
