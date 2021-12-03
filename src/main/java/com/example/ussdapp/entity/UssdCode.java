package com.example.ussdapp.entity;

import com.example.ussdapp.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UssdCode extends AbsNameEntity {
    private String code; //101 102
    private String description;
}
