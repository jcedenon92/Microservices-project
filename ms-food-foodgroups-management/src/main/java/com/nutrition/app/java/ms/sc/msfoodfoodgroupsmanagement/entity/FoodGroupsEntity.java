package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "food_groups")
public class FoodGroupsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFoodgroups;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "status", nullable = false)
    private boolean status;
}
