package com.bugra.kitaptakipapi;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin123456"; //
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}
