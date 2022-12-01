package com.roles.permission.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//methods - for jwt token
//validate
//isExp
//util class for jwt

@Component
public class JwtTokenUtil {

	    private String SECRET_KEY = "Java";
	    
	    /* Claims - Predefined Class . it takes getSubject() */
	    
	    // getting username from jwt token
	    public String getUsernameFromToken(String token) {
	        return getClaimFromToken(token, Claims::getSubject);
	    }
	    
	    /* Claims - Predefined Class . it takes getExpiration() */ 

	    // getting expiration date from jwt token
		public Date getExpirationDateFromToken(String token) {
	        return getClaimFromToken(token, Claims::getExpiration);
	    }
		
		/* Take The Token From Here... */
		/* Getting Information From Token With The Help of SECRET KEY */

		// getting any info from token we need secret key
	    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = getAllClaimsFromToken(token);
	        return claimsResolver.apply(claims);
	    }
	    
	    /* Function<Claims,T> - it is Functional Interface */
	    
	    private Claims getAllClaimsFromToken(String token) {
	        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	    }

	    /* its Just Check Token Expired or Not */
	    
	    // Check if token Expired Or Not
	    private Boolean isTokenExpired(String token) {
	        return getExpirationDateFromToken(token).before(new Date());
	    }
	    
	    /* Start The Create Token With Help of UserDetails */

	    // Generate Token
	    public String generateToken(UserDetails userDetails) {
	        Map<String, Object> claims = new HashMap<>();
	        return doGenerateToken(claims, userDetails.getUsername());
	    }


	    // While Create Token
//	    1. Define Claims of the Token Like Issuer, Expiration, Subject & Id
//	    2. Sign the JWT using the HS256 algorithm & secret key
	    
	    /* While Creating We Need Builder Method From Jwts Predefined Class to Set the Claims, Subject, Start Date, End Date, Signature Algorithm & SECRET KEY */

	    // Create Token
	    private String doGenerateToken(Map<String, Object> claims, String subject) {

	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	    }
	    
	    /* Finally, Token Generated Then Getting Username From Token 
	     * & 
	     * Check The Token Is Valid Or Not ( if token is not Expired Then It Return Username )  */

	    // Validate Token
	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = getUsernameFromToken(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }

}
