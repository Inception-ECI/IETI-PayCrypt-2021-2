package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.TokenDto;
import com.inception.paycrypt.model.User;
import org.springframework.stereotype.Service;

/**
 * Define the signature to implement a Authentication Service
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface AuthService {

    /**
     * Generates the token for an authenticated user
     *
     * @param user The authenticated {@link User}
     * @return The data of the generated token
     */
    TokenDto generateToken(User user);
}
