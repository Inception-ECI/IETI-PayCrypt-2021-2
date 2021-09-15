package com.inception.paycrypt.controller;

import com.inception.paycrypt.dto.LoginDto;
import com.inception.paycrypt.dto.TokenDto;
import com.inception.paycrypt.exception.AuthServiceException;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.service.AuthService;
import com.inception.paycrypt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final UserService userService;

    private final AuthService authService;

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {

        User user = userService.findByEmail(loginDto.getEmail());
        if (BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {
            return authService.generateToken(user);
        }

        throw new AuthServiceException(AuthServiceException.INVALID_CREDENTIALS);
    }
}
