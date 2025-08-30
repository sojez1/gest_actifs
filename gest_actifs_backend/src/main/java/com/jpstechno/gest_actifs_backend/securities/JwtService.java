package com.jpstechno.gest_actifs_backend.securities;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    Map<String, Object> claims = new HashMap<>();
    final long dureeToken = 24 * 3600 * 1000; // 24 h en ms

    private final String SECRET = "FtUHrNIjkDZROTXdFxzyuaBZkRNBtQfEGMOCVfuxwjtGyOlRyLe";

    public String generateToken(String email) {

        /*
         * return Jwts.builder().claims()
         * .issuer(null)
         * .subject(email)
         * .issuedAt(new Date(System.currentTimeMillis()))
         * .expiration(new Date(System.currentTimeMillis() + dureeToken))
         * .and()
         * .signWith(getKey())
         * .compact();
         */

        return Jwts.builder().setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + dureeToken))
                .signWith(getKey(), io.jsonwebtoken.SignatureAlgorithm.HS256).compact();

    }

    private Key getKey() {
        byte[] keybytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keybytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getKey()).build()
                .parseClaimsJws(token).getBody();

    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpire(token));
    }

    private boolean isTokenExpire(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}
