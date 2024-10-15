package org.mvc.itvdnstudyspringmvc2.services;

import lombok.RequiredArgsConstructor;
import org.mvc.itvdnstudyspringmvc2.controllers.api.requests.LoginRequest;
import org.mvc.itvdnstudyspringmvc2.controllers.api.requests.RegisterRequest;
import org.mvc.itvdnstudyspringmvc2.controllers.api.response.AuthResponse;
import org.mvc.itvdnstudyspringmvc2.model.Role;
import org.mvc.itvdnstudyspringmvc2.model.User;
import org.mvc.itvdnstudyspringmvc2.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JWTService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .pass(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findUserByUsername
                (request.getUsername()).orElseThrow();
        var jwt = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwt)
                .build();
    }
}
