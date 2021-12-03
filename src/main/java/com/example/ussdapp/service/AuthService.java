package com.example.ussdapp.service;

import com.example.ussdapp.entity.User;
import com.example.ussdapp.payload.ApiResponse;
import com.example.ussdapp.payload.AuthRegisterDTO;
import com.example.ussdapp.payload.LoginDto;
import com.example.ussdapp.repository.RoleRepository;
import com.example.ussdapp.repository.UserRepository;
import com.example.ussdapp.security.JwtProvider;
import com.example.ussdapp.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            return byEmail.get();
        }
        throw new UsernameNotFoundException("Bunday email mavjud emas");
    }

    public ApiResponse registerUser(AuthRegisterDTO authRegisterDTO) throws ChangeSetPersister.NotFoundException {
        boolean exists = userRepository.existsByEmail(authRegisterDTO.getEmail());
        if (exists) return new ApiResponse("Bu email ro'yxatda mavjud", false);

        if (!authRegisterDTO.getPrePassword().equals(authRegisterDTO.getPassword()))
            return new ApiResponse("PrePassword noto'g'ri", false);

        User user;
        user = new User(authRegisterDTO.getFullName(), authRegisterDTO.getEmail(), passwordEncoder.encode( authRegisterDTO.getPassword()), roleRepository.findByName(Constants.USER).orElseThrow(() -> new ChangeSetPersister.NotFoundException()), true);
        userRepository.save(user);
        return new ApiResponse("Ro'yxatdan muvaffaqiyatli o'tdingiz", true);
    }

    public ApiResponse loginUser(LoginDto loginDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        User user=(User)authenticate.getPrincipal();
        String token = jwtProvider.generateToken(user.getEmail(), user.getRole());
        return new ApiResponse("OK",true,token);
    }
}
