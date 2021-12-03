package com.example.ussdapp.entity;

import com.example.ussdapp.entity.enums.Type;
import com.example.ussdapp.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Packet extends AbsNameEntity {

    @Enumerated(EnumType.STRING)
    private Type type;
    private double amount; //5Gb
    private double price;
    private int dueDate;
    private Date expiredDate;
    private boolean saveRemainder = true; //qoldiqqa qo'shish

    @ManyToMany
    private List<Tariff> tariffs;
}
