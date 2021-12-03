package com.example.ussdapp.entity;

import com.example.ussdapp.entity.enums.ActionType;
import com.example.ussdapp.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Details extends AbsEntity {

    @ManyToOne
    private SimCard simCard;

    private Date date;

    @Enumerated
    private ActionType actionType;
    //miqdor yo sum
    private double amount;

}
