package com.hsilva.msauth.application.web;

import com.hsilva.msauth.application.entity.User;
import com.hsilva.msauth.application.service.AuthenticationService;
import com.hsilva.msauth.infra.security.TokenJWT;
import com.hsilva.msauth.infra.security.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    @PostMapping
    public TokenJWT authenticate(@RequestBody AuthRequestDTO authRequestDTO){
        var authToken = new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword());
        var auth = authenticationManager.authenticate(authToken);

        String token = this.tokenService.createToken((User) auth.getPrincipal());

        return new TokenJWT(token);
    }

    @GetMapping("/{token}")
    public AuthDTO clarify(@PathVariable String token){
        return new AuthDTO();
    }

}