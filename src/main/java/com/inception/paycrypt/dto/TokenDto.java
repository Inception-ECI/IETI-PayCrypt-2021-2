package com.inception.paycrypt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Mapping class for the authentication token
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {

    /**
     * The token provided by the server
     */
    private String token;

    /**
     * The expiration date of the token
     */
    private Date expirationDate;
}
