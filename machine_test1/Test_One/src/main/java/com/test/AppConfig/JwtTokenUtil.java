//package com.test.AppConfig;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtTokenUtil {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private int expiration;
//
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    public String getUsernameFromToken(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//        return claims.getSubject();
//    }
//
//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        String username = getUsernameFromToken(token);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        Date expirationDate = Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody()
//                .getExpiration();
//        return expirationDate.before(new Date());
//    }
//}
//
