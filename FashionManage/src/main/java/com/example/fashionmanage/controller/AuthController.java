package com.example.fashionmanage.controller;


import ch.qos.logback.core.util.Duration;
import com.example.fashionmanage.dto.AuthCredentialsRequest;
import com.example.fashionmanage.dto.PasswordChangeRequest;
import com.example.fashionmanage.entity.User;
import com.example.fashionmanage.service.UserDetailServiceImp;
import com.example.fashionmanage.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
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
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()));

            User user = (User) authenticate.getPrincipal();
            user.setPassword(null);

            String token = jwtUtil.generateToken(user);
            ResponseCookie cookie = ResponseCookie.from("jwt", token)
                    .domain(domain)
                    .path("/")
                    .maxAge(Duration.buildByDays(365).getMilliseconds())
                    .build();

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .body(token);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * Method : validateToken
     * <p>Check JWT token valid</p>
     *
     * @param JWT token
     * @return Boolean
     * @author AiPV
     */
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@CookieValue(name = "jwt") String token,
                                           @AuthenticationPrincipal User user) {
        try {
            Boolean isValidToken = jwtUtil.validateToken(token, user);
            return ResponseEntity.ok(isValidToken);
        } catch (ExpiredJwtException e) {
            return ResponseEntity.ok(false);
        }
    }

    /**
     * Method : logout
     * <p>Logout current user </p>
     *
     * @author AiPV
     */
    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
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
     * @author AiPV
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
            return new ResponseEntity<>("The new password and confirm password",HttpStatus.UNAUTHORIZED );
        }
    }
}
