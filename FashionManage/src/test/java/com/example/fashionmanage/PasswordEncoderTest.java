package com.example.fashionmanage;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
    @Test
    public void testPasswordEncoder() throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("saler"));
        System.out.println(encoder.encode("warehouse"));
    }
}
