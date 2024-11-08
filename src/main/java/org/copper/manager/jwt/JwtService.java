package org.copper.manager.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    boolean isTokenExpired(String token);

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    Long getUserIdFromToken(String token);
}
