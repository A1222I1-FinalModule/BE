package com.example.fashionmanage.filler;

import com.example.fashionmanage.entity.User;
import com.example.fashionmanage.repository.UserRepository;
import com.example.fashionmanage.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter{
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final  String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(StringUtils.isEmpty(header) || !header.startsWith("Bearer ")){
            chain.doFilter(request, response);
            return;
        }

        String token = header.split(" ")[1].trim();
        UserDetails userDetails = null;
        try {
            Optional<User> appUserOpt = userRepo.findByUsername(jwtUtil.getUsernameFromToken(token));
            userDetails = userRepo.findByUsername(jwtUtil.getUsernameFromToken(token)).orElse(null);
        } catch (ExpiredJwtException | SignatureException e) {
            chain.doFilter(request, response);
            return;
        }

        // Get jwt token and validate
        if (!jwtUtil.validateToken(token, userDetails)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ?
                        List.of() : userDetails.getAuthorities()
        );
        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );
        // this is where the authentication magic happens and the user is now valid!
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);

    }
}
