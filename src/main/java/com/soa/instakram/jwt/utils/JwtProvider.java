package com.soa.instakram.jwt.utils;

import com.soa.instakram.global.error.exception.TokenNotValidateException;
import com.soa.instakram.member.entity.Member;
import com.soa.instakram.member.service.PrincipalDetailService;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

import java.security.Key;
import java.security.SignatureException;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtProvider {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String GRANT_TYPE = "Bearer ";
    private static final long AT_EXPIRED_DURATION = 20 * 60 * 60 * 1000;

    private final PrincipalDetailService principalDetailService;
    public String generateToken(Member member) {
        long now = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(member.getEmail())
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + AT_EXPIRED_DURATION))
                .signWith(JwtKey.SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(GRANT_TYPE)) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public void validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(JwtKey.SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
        } catch (MalformedJwtException e) {
            throw new TokenNotValidateException("토큰이 올바르지 않습니다.");
        } catch (ExpiredJwtException e) {
            throw new TokenNotValidateException("토큰이 만료되었습니다.");
        } catch (IllegalArgumentException e) {
            throw new TokenNotValidateException("토큰이 주어지지 않았습니다.");
        }
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JwtKey.SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        UserDetails userDetails = principalDetailService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, token, userDetails.getAuthorities());
    }
}
