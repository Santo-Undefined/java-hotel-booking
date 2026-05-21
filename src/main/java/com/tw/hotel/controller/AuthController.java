package com.tw.hotel.controller;


import com.tw.hotel.exceptions.ExistingUser;
import com.tw.hotel.exceptions.InvalidCredentials;
import com.tw.hotel.exceptions.UserNotFound;
import com.tw.hotel.requestDto.UserRequestDto;
import com.tw.hotel.service.JwtService;
import com.tw.hotel.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/api/users")
public class AuthController {
    private final JwtService jwtService;
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Value("${security.jwt.expiration-time}")
    private long EXPIRATION_TIME;

    public AuthController(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> signup(@Valid @RequestBody UserRequestDto user) throws ExistingUser {
        try {
            logger.info("signup user with {}", user);
            UserResponseDto userResponseDto = userService.signUp(user);
            String token = jwtService.generateToken(userResponseDto.username());
            ResponseCookie cookie = ResponseCookie.from("jwt", token)
                    .httpOnly(true)
                    .secure(true)
                    .sameSite("Strict")
                    .path("/")
                    .maxAge(Duration.ofMillis(EXPIRATION_TIME))
                    .build();

            logger.info("user {} successfully logged in", userResponseDto.username());
            return ResponseEntity.status(201)
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .build();
        } catch (Throwable e){
            if (e instanceof UserNotFound || e instanceof InvalidCredentials){
                return ResponseEntity.badRequest().build();
            }
            throw e;
        }
    }

}

