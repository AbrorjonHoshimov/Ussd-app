package com.example.ussdapp.payload;

import com.example.ussdapp.entity.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PakaketDTO {
    private Type type;
    private double amount; //5Gb
    private double price;
    private String name;
    private int dueDate;
    private List<Integer> tariffList;
}
