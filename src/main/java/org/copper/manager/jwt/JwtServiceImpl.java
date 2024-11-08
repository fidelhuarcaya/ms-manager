package org.copper.manager.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.copper.manager.exception.RequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expiration-time}")
    private long expirationTime;

    private Key getKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public boolean isTokenExpired(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return claims.getBody().getExpiration().before(new Date());
        } catch (JwtException e) {
            return true;
        }
    }


    @Override
    public String getUsernameFromToken(String token) {
        Jws<Claims> claimsJws = getAllClaims(resolveToken(token));
        if (Objects.nonNull(claimsJws)) {
            return claimsJws.getBody().getSubject();
        }
        throw new RequestException("The token is invalid.");

    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    @Override
    public Long getUserIdFromToken(String token) {
        Jws<Claims> claimsJws = getAllClaims(resolveToken(token));
        if (Objects.nonNull(claimsJws)) {
            String id = findClaimByKey(claimsJws.getBody(), "id");
            if (Objects.isNull(id)) {
                throw new RequestException("The token is invalid.");
            }
            return Long.parseLong(id);
        }
        throw new RequestException("The token is invalid.");
    }

    private Jws<Claims> getAllClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            return null;
        }

    }

    private String findClaimByKey(Map<String, Object> claims, String key) {
        if (claims.containsKey(key)) {
            return claims.get(key).toString();
        }
        return null;
    }


    private String resolveToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return bearerToken;
    }
}

