package com.nutrition.app.java.ms.sc.msusercustomermanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user_client")
public class UserClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserClient;

    @Column(name = "first_name", nullable = false, length = 200)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 200)
    private String lastName;

    @Column(name = "suname", nullable = false, length = 200)
    private String surname;

    @Column(name = "username", nullable = false, length = 200)
    private String username;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user_client", referencedColumnName = "idUserClient"), inverseJoinColumns = @JoinColumn(name = "id_role_client", referencedColumnName = "idRoleClient"))
    private List<RoleClientEntity> roles;
}
