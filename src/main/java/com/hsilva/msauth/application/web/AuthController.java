package com.hsilva.msauth.application.web;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @GetMapping("/{token}")
    public AuthDTO clarify(@PathVariable String token){
        return new AuthDTO();
    }

    @PostMapping
    public String authenticate(@RequestBody AuthRequestDTO authRequestDTO){
        return new String(UUID.randomUUID().toString());
    }
}
