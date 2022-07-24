package com.example.demo.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.exceptions.ResourceNotFoundException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenHelper {
	
	
	@Value("${jwt.auth.app}")
	private String appName;
	
	@Value("${jwt.auth.secret_key}")
	private String secretKey;
	
	@Value("${jwt.auth.expires_in}")
    private int expiresIn;
	
	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;


	
	private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

	
	 public String getUsernameFromToken(String token) {
	        String username = null;
	        try {
	            final Claims claims = this.getAllClaimsFromToken(token);
	            if(claims!=null) {
	            	username = claims.getSubject();
	            }
	            
	        } catch (Exception e) {
	        	throw new ResourceNotFoundException("Got Its");
	        }
	        return username;
	 }
	 
	 public String generateToken(String username){
	        
	        return Jwts.builder()
	                .setIssuer( appName )
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(generateExpirationDate())
	                .signWith( SIGNATURE_ALGORITHM, secretKey )
	                .compact();
	  }
	 
	 private Date generateExpirationDate() {
		 return new Date(new Date().getTime() + expiresIn * 1000);
	 }
	 
	 public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = getUsernameFromToken(token);
	        return (
	                username != null &&
	                username.equals(userDetails.getUsername()) &&
	                        !isTokenExpired(token)
	        );
	  }
	 
	 public boolean isTokenExpired(String token) {
		Date expireDate=getExpirationDate(token);
		Boolean m = false;
		if(expireDate!=null) {
			m = expireDate.before(new Date());
		}
		return m;
	}


	private Date getExpirationDate(String token) {
		 Date expireDate = null;
	        try {
	            final Claims claims = this.getAllClaimsFromToken(token);
	            if(claims!=null) {
	            	expireDate = claims.getExpiration();
	            }
	            
	        } catch (Exception e) {
	        	throw new ResourceNotFoundException("Got Itss");
	        }
	        return expireDate;
	}


	public Date getIssuedAtDateFromToken(String token){
	        Date issueAt = null;
	        try {
	            final Claims claims = this.getAllClaimsFromToken(token);
	            if(claims!=null) {
	            	issueAt = claims.getIssuedAt();
	            }
	            
	        } catch (Exception e) {
	        	throw new ResourceNotFoundException("Got It");
	        }
	        return issueAt;
	  }
	
	public String getToken( HttpServletRequest request ) {
      
        String authHeader = getAuthHeaderFromHeader( request );
        if ( authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

	public String getAuthHeaderFromHeader( HttpServletRequest request ) {
        return request.getHeader("Authorization");
    }
}