package com.example.ussdapp.payload;

import com.example.ussdapp.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilialDTO {
    private String name;
    //    private List<Staff> staffList; agar buni qo'shsam hodimlarni birma bir qo'shib chiqishga to'g'ri keladi
    private Staff director;
    private Staff filialManager;
}
