package com.moctho.mockthoapi.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class jwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

   private final AuthenticationManager authenticationManager;

    public jwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try{

            jwtAuthenticationRequest authenticationRequest =   new ObjectMapper().readValue(request.getInputStream(),jwtAuthenticationRequest.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUserName(),
                    authenticationRequest.getPassword()
            );
            return authenticationManager.authenticate(authentication);
        }catch (IOException e){

            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String keys = "MYPASSWOERDDDMKEKEORORPMFMFMSEcurewmwkeeorlffmdmernfndmld";

       String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities",authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
                .signWith(Keys.hmacShaKeyFor(keys.getBytes())).compact();

         response.addHeader("Authorisation","Bearer " + token);
    }
}
