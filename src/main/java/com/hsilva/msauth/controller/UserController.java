package com.hsilva.msauth.controller;

import com.hsilva.msauth.controller.dto.UserDTO;
import com.hsilva.msauth.controller.dto.UserDetailDTO;
import com.hsilva.msauth.controller.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserDTO userDTO){

        this.userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDetailDTO> findById(@PathVariable String uuid){
        return ResponseEntity.ok(this.userService.findById(uuid));
    }

    @DeleteMapping("/{uuid}")
    public void inactivate(@PathVariable String uuid){
        this.userService.inactivate(uuid);
    }

}
