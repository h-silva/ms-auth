package com.hsilva.msauth.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hsilva.msauth.controller.domain.entity.User;
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
                    .withExpiresAt(expireDateBySeconds(600l))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new SecurityException("Failed to generate token");
        }
    }

    public Instant expireDateBySeconds(Long seconds){
        return LocalDateTime.now().plusSeconds(seconds).toInstant(ZoneOffset.of("-03:00"));
    }

    public Object clarify(String token){
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify an specific claim validations
                    .withIssuer("MS-AUTH")
                    // reusable verifier instance
                    .build();

            decodedJWT = verifier.verify(token);

            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception){
            throw new SecurityException("Invalidated Token");
        }
    }
}
