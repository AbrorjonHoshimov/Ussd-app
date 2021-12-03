package com.example.ussdapp.entity;


import com.example.ussdapp.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntertainmentService extends AbsNameEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    Category category;

    private double price;
    private int dueDate; //1kunli
}
