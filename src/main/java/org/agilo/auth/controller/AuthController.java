package org.agilo.auth.controller;

import org.agilo.auth.dto.LoginResponse;
import org.agilo.auth.dto.LoginUserDto;
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
        User registeredUser = authenticationService.signup(registerRequestDto);
        return ResponseEntity.ok(RegisterResponseDto.builder()
                .id(registeredUser.getId())
                .email(registeredUser.getEmail())
                .createdAt(registeredUser.getCreatedAt())
                .build()
        );
    }

    @PostMapping(AuthEndpoints.LOGIN_ENDPOINT)
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();
        return ResponseEntity.ok(loginResponse);
    }
}
