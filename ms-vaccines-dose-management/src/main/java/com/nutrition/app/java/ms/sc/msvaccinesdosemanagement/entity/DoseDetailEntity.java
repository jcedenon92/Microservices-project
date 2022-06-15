package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "dose_detail")
public class DoseDetailEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDosedetail;

    @ManyToOne
    @JoinColumn(name = "id_vaccine", nullable = false, foreignKey = @ForeignKey(name = "fk_dose_detail_vaccine"))
    private VaccineEntity vaccine;

    @Column(nullable = false)
    private String month;
}
