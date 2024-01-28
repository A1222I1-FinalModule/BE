package com.example.fashionmanage.controller;


import ch.qos.logback.core.util.Duration;
import com.example.fashionmanage.dto.AuthCredentialsRequest;
import com.example.fashionmanage.dto.PasswordChangeRequest;
import com.example.fashionmanage.dto.TokenRequest;
import com.example.fashionmanage.entity.Employee;
import com.example.fashionmanage.entity.User;
import com.example.fashionmanage.repository.UserRepository;
import com.example.fashionmanage.service.UserDetailServiceImp;
import com.example.fashionmanage.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailServiceImp userDetailServiceImp;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepo;
    @Value("${cookies.domain}")
    private String domain;

    /**
     * Method : login
     * <p>Validate login request</p>
     * <p>If User Valid create and return JWT Token</p>
     * <p>Else Return UNAUTHORIZED</p>
     *
     * @param request the request
     * @return JWT Token
     * @author AiPV"
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            User user = (User) authenticate.getPrincipal();
            user.setPassword(null);

            String token = jwtUtil.generateToken(user);
            return ResponseEntity.ok()
                    .body(token);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * Method : validateToken
     * <p>Check JWT token valid</p>
     *
     * @param  token
     * @return Boolean
     * @author AiPV
     */
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(HttpServletRequest request,
                                           @AuthenticationPrincipal User user) {
        final  String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(StringUtils.isEmpty(header) || !header.startsWith("Bearer ")){
            return ResponseEntity.ok(false);
        }

        String token = header.split(" ")[1].trim();
        try {
            Boolean isValidToken = jwtUtil.validateToken(token, user);
            return ResponseEntity.ok(isValidToken);
        } catch (ExpiredJwtException e) {
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout () {
        ResponseCookie cookie = ResponseCookie.from("jwt", "")
                .domain(domain)
                .path("/")
                .maxAge(0)
                .build();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString()).body("ok");
    }
    /**
     * Change the password for the current user
     *
     * @param request
     * @param user
     * @return Boolean
     */
    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeRequest request, @AuthenticationPrincipal User user) {
        //            handle new password and confirm password
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("The new password and confirm password not match");
        }
        // hanlde current password match with server
        String currentPassword = userDetailServiceImp.findPasswordByUsername(user.getUsername());
        if (passwordEncoder.matches(request.getOldPassword(), currentPassword)) {
//            throw  new IllegalStateException("The new password and confirm password");
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userDetailServiceImp.save(user);
            return ResponseEntity.ok().build();

        } else {
            return ResponseEntity.badRequest().body("The Old Password not correct");
        }
    }
}
