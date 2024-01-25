package com.example.fashionmanage.config;


import com.example.fashionmanage.filler.JwtFilter;
import com.example.fashionmanage.service.UserDetailServiceImp;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private UserDetailServiceImp userDetailsService;
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImp();
    }
    /**
     * method :corsConfigurationSource
     * <p>config CORS can allow access to server</p>
     *
     * @return CorsConfigurationSource
     * @author AiPV
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        configuration.setAllowedHeaders(
                Arrays.asList("Authorization", "X-Requested-With", "Origin", "Content-Type", "Accept", "ContentType"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setMaxAge(3600L);
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    /**
     * method :securityFilterChain
     * <p>config httpSecurity</p>
     *
     * @return SecurityFilterChain
     * @author AiPV
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http = http.csrf(crf -> crf.disable());
        http = http.sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http = http.exceptionHandling((exc) -> exc.authenticationEntryPoint((req, res, ex) -> {
            System.out.println(ex.getClass());
            res.sendError(HttpServletResponse.SC_FORBIDDEN,ex.getMessage());
        }));
        http = http.authorizeHttpRequests((author) -> author
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/public/**").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/saler/**").hasRole("SALE")
                .requestMatchers("/api/warehouse/**").hasRole("WAREHOUSE")
                .anyRequest().authenticated());
        http = http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /**
     * method :PasswordEncoder
     * <p>create passwordEncoder by BCryptPasswordEncoder</p>
     *
     * @return PasswordEncoder
     * @author AiPV
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * method :authenticationProvider
     * <p>Config Authentication Context</p>
     *
     * @return AuthenticationProvider
     * @author AiPV
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    /**
     * method :authManagerBean
     * <p>Config Authentication Manager</p>
     *
     * @return ProviderManager
     * @author AiPV
     */
    @Bean
    public ProviderManager authManagerBean(HttpSecurity security) throws Exception {
        return (ProviderManager) security.getSharedObject(AuthenticationManagerBuilder.class).authenticationProvider(authenticationProvider()).build();
    }

}
