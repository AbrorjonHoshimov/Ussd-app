package com.example.ussdapp.entity;

import com.example.ussdapp.entity.enums.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //huquqlar ro'yxati
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Permission> permissions;

    public Role(String name, List<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }
}
