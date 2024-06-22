package com.alexandre.sboot_financeiro_back_app.infrastructure.security;

import com.alexandre.sboot_financeiro_back_app.domain.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    private static final String SEC_KEY = "e55edffe5fb908ce92724977c76f8785403e24354a6d15b18ef1e4331f7cf06b682b2a2ea183cc338dde839ea8194aee84cc285758546718c36640ba3b0ac74b";

    @Override
    public String getUserNameToken(String token) {
        Claims claims = Jwts.parser()
                            .verifyWith(getSecretKey())
                            .build()
                            .parseSignedClaims(token)
                            .getPayload();
        return claims.getSubject();
    }

    @Override
    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return Jwts.builder()
                .issuer("Security API")
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(Date.from(Instant.now().plusSeconds(60000)))
                .signWith(getSecretKey())
                .compact();
    }

    @Override
    public boolean isTokenValido(String token) {
        try {
            Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = SEC_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
