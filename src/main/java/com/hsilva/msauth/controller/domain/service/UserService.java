package com.hsilva.msauth.controller.domain.service;

import com.hsilva.msauth.controller.domain.entity.User;
import com.hsilva.msauth.controller.domain.repository.UserRepository;
import com.hsilva.msauth.controller.dto.UserDTO;
import com.hsilva.msauth.controller.dto.UserDetailDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptEncoder;


    public void createUser(UserDTO userDTO){

        User user = new User(userDTO.getUsername(), bCryptEncoder.encode(userDTO.getPassword()));
        user.setActive(true);

        this.userRepository.save(user);
    }

    public UserDetailDTO findById(String uuid){
        User user = this.userRepository.findById(uuid).orElseThrow();
        return new UserDetailDTO(user);
    }

    public void inactivate(String uuid){
        User user = this.userRepository.findById(uuid).orElseThrow();
        user.setActive(false);
        this.userRepository.save(user);
    }
}
