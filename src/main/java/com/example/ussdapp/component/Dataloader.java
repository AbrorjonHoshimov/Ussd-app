package com.example.ussdapp.component;

import com.example.ussdapp.entity.Filial;
import com.example.ussdapp.entity.Role;
import com.example.ussdapp.entity.Staff;
import com.example.ussdapp.entity.enums.Permission;
import com.example.ussdapp.repository.FilialRepository;
import com.example.ussdapp.repository.RoleRepository;
import com.example.ussdapp.repository.StaffRepository;
import com.example.ussdapp.repository.UserRepository;
import com.example.ussdapp.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

import static com.example.ussdapp.entity.enums.Permission.*;

@Component
public class Dataloader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FilialRepository filialRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    RoleRepository roleRepository;



    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) throws Exception {
        Permission[] values = values();
        if (initMode.equals("always")) {
            Staff director = staffRepository.save(new Staff("Director", "director", "director"));
            Staff staff = staffRepository.save(new Staff("Xodim", "xodim", "xodim"));

            filialRepository.save(new Filial("PDP",Collections.singletonList(staff),director));

             roleRepository.save(new Role(Constants.DIRECTOR,
                    Arrays.asList(values)));
             roleRepository.save(new Role(Constants.USER,
                    Arrays.asList(GET_SIMCARD)));

        }
    }
}
