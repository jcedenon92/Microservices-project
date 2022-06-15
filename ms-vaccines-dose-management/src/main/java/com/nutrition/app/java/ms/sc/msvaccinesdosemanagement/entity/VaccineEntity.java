package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "vaccine")
public class VaccineEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVaccine;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "vaccine", cascade = CascadeType.ALL)
    private List<DoseDetailEntity> doseDetails;
}
