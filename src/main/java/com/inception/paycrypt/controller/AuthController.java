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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Authentication Controller
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@CrossOrigin(originPatterns = "*", origins = "*")
@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    /**
     * The {@link UserService}
     */
    private final UserService userService;

    /**
     * The {@link AuthService}
     */
    private final AuthService authService;

    /**
     * The login endpoint
     *
     * @param loginDto The credentials provided to authenticate
     * @return a token if the login was successful
     */
    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {

        User user = userService.findByEmail(loginDto.getEmail());
        if (BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {
            return authService.generateToken(user);
        }

        throw new AuthServiceException(AuthServiceException.INVALID_CREDENTIALS);
    }
}
