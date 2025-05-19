package com.ark.poc.services;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface IJwtService {

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsTFunction);

    String generateToken(UserDetails userDetails);

    Long getExpirationTime();

    Boolean isTokenValid(String token, UserDetails userDetails);

}
