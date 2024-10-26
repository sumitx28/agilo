package org.agilo.auth.controller;

import org.agilo.auth.dto.LoginResponseDto;
import org.agilo.auth.dto.LoginRequestDto;
import org.agilo.auth.dto.RegisterRequestDto;
import org.agilo.auth.dto.RegisterResponseDto;
import org.agilo.auth.model.User;
import org.agilo.auth.service.AuthenticationService;
import org.agilo.auth.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuthEndpoints.AUTH_CONTROLLER_ENDPOINT)
public class AuthController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping(AuthEndpoints.SIGNUP_ENDPOINT)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        RegisterResponseDto registerResponseDto = authenticationService.signup(registerRequestDto);
        return ResponseEntity.ok(registerResponseDto);
    }

    @PostMapping(AuthEndpoints.LOGIN_ENDPOINT)
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = authenticationService.login(loginRequestDto);
        return ResponseEntity.ok(loginResponseDto);
    }
}
