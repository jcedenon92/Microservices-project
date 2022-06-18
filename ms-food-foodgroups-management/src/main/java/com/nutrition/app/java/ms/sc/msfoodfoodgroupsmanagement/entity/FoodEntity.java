package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "food")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFood;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "energy_kcal", nullable = false)
    private String energyKcal;
/*
    @Column(name = "protein", nullable = false)
    private String protein;

    @Column(name = "carbohydrate", nullable = false)
    private String carbohydrates;

    @Column(name = "iron", nullable = false)
    private String iron;

    @Column(name = "vitamin_a", nullable = false)
    private String vitaminA;

    @Column(name = "vitamin_c", nullable = false)
    private String vitaminC;
*/
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "id_foodgroups", nullable = false, foreignKey = @ForeignKey(name = "fk_food_foodgroup"))
    private FoodGroupsEntity foodGroups;
}
