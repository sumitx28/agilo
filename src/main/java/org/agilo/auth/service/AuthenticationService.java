package org.agilo.auth.service;

import org.agilo.auth.dto.LoginRequestDto;
import org.agilo.auth.dto.LoginResponseDto;
import org.agilo.auth.dto.RegisterRequestDto;
import org.agilo.auth.model.User;
import org.agilo.auth.repository.UserRepository;
import org.agilo.exception.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public User signup(RegisterRequestDto input) {
        User existingUser = userRepository.findByEmail(input.getEmail()).orElse(null);
        if (existingUser != null) {
            throw new Exception("DUPLICATE USER", "User with email " + input.getEmail() + " already exists", HttpStatus.BAD_REQUEST);
        }
        User user = User.builder()
                .fullName(input.getFullName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();
        return userRepository.save(user);
    }

    public User authenticate(LoginRequestDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

    public LoginResponseDto login(LoginRequestDto input) {
        User currentUser = authenticate(input);
        String jwtToken = jwtService.generateToken(currentUser);
        return LoginResponseDto.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).id(currentUser.getId()).email(currentUser.getEmail()).build();
    }
}
