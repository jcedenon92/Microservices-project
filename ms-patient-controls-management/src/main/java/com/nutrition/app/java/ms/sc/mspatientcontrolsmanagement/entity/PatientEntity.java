package com.nutrition.app.java.ms.sc.mspatientcontrolsmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idPatient;

    @Column(nullable = false, length = 250)
    private String names;

    @Column(nullable = false, length = 250)
    private String surnames;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @Column(nullable = false, length = 200)
    private String gender;

    private Integer gestationTime;

    @Column(nullable = false)
    private boolean state;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }

}
