package com.nutrition.app.java.ms.sc.msusercustomermanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role_client")
public class RoleClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoleClient;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "status", nullable = false)
    private boolean status;
}
