package com.example.admin.security.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtil {
	
	private String secret="aravind";
public String extractUsername(String token) {
	return extractClaim(token,Claims::getSubject);
}

public Date extractExpiration(String token) {
	return extractClaim(token,Claims::getExpiration);
}

private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
	final Claims claims=extractAllclaims(token);
	
	return null;
}

private Claims extractAllclaims(String token) {
	// TODO Auto-generated method stub
	return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
}
private Boolean isTokenExpired(String token) {
	return extractExpiration(token).before(new Date());
}
public String generateTokens(String username) {
	Map<String,Object> claims=new HashMap<>();
	return createToken(claims,username);
}

private String createToken(Map<String, Object> claims, String subject) {
	// TODO Auto-generated method stub
	return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10)).signWith(SignatureAlgorithm.HS256, secret).compact();
			
}
public Boolean ValidateToken(String token,UserDetails userdetails) {
	final String Username=extractUsername(token);
	return (Username.equals(userdetails.getUsername()) && !isTokenExpired(token));
}
}
