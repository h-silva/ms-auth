package com.hsilva.msauth.application.web;

import com.hsilva.msauth.infra.TokenJWT;
import com.hsilva.msauth.infra.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    @GetMapping("/{token}")
    public AuthDTO clarify(@PathVariable String token){
        return new AuthDTO();
    }

    @PostMapping
    public TokenJWT authenticate(@RequestBody AuthRequestDTO authRequestDTO){
        return new TokenJWT(UUID.randomUUID().toString());
    }
}
