package com.example.ussdapp.payload;

import com.example.ussdapp.entity.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {
    private String fullName;
    private String userName;
    private String password;
    private Position position;
    private UUID filialId;

}
