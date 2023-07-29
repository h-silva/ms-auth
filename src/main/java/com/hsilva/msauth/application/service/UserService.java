package com.hsilva.msauth.application.service;

import com.hsilva.msauth.application.entity.User;
import com.hsilva.msauth.application.repository.UserRepository;
import com.hsilva.msauth.application.web.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void createUser(UserDTO userDTO){

        User user = new User(userDTO);

        this.userRepository.save(user);
    }

    public User findById(String uuid){
        return this.userRepository.findById(uuid).orElseThrow();
    }

    public void inactivate(String uuid){
        User user = this.userRepository.findById(uuid).orElseThrow();
        user.setActive(false);
        this.userRepository.save(user);
    }
}
