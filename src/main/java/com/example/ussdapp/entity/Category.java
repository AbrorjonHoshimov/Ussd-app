package com.example.ussdapp.entity;

import com.example.ussdapp.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
public class Category extends AbsNameEntity {

}
