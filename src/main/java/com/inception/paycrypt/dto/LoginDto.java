package com.inception.paycrypt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mapping class for the login
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
public class LoginDto {

    /**
     * The provided Email
     */
    private String email;

    /**
     * The provided password
     */
    private String password;
}
