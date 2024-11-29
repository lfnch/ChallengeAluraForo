package com.lfng7.ChallengeAluraForo.controller;

import com.lfng7.ChallengeAluraForo.domain.user.UserEntity;
import com.lfng7.ChallengeAluraForo.domain.user.dto.UserLoginDto;
import com.lfng7.ChallengeAluraForo.infra.security.JwtTokenDto;
import com.lfng7.ChallengeAluraForo.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<JwtTokenDto> authenticateteUser(@RequestBody @Valid UserLoginDto userDto) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                userDto.email(),
                userDto.password());
        var userAuth = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generateToken((UserEntity) userAuth.getPrincipal());
        return ResponseEntity.ok(new JwtTokenDto(jwtToken));
    }
}

