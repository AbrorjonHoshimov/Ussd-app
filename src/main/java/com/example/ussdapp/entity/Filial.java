package com.example.ussdapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filial")
    private List<Staff> staffList;

    @OneToOne
    private Staff director;

    @OneToOne
    private Staff filialManager;

    public Filial(String name, List<Staff> staffList, Staff director) {
        this.name = name;
        this.staffList = staffList;
        this.director = director;
    }
}
