package com.watchparty.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims; 
import io.jsonwebtoken.Jwts; 
import io.jsonwebtoken.SignatureAlgorithm; 
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService{
    
    private final String SECRET = "azxjhd34r3c9023c2342.c234c2342.23/234.234?";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
    
    public String generateToken(String username){
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
            .signWith(key,SignatureAlgorithm.HS256)
            .compact();
    }
    
    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        }catch(Exception e){
            return false;
        }
    } 
    
    
    
}