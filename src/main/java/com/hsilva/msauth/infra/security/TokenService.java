package com.hsilva.msauth.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.hsilva.msauth.application.entity.User;
import com.hsilva.msauth.application.web.AuthDTO;
import com.hsilva.msauth.application.web.AuthRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;


    public String createToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String token = JWT.create()
                    .withIssuer("MS-AUTH")
                    .withSubject(user.getUsername())
                    .withClaim("foobar", "foobar")
                    .withExpiresAt(expireDateBySeconds(5000l))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new SecurityException("Failed to generate token");
        }
    }

    public Instant expireDateBySeconds(Long seconds){
        return LocalDateTime.now().plusSeconds(seconds).toInstant(ZoneOffset.of("-03:00"));
    }
}