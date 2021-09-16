package com.inception.paycrypt.utils.constants;

/**
 * JWT authentication constants
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class JwtConstants {

    /**
     * The session duration for the token
     */
    public static final int TOKEN_DURATION_MINUTES = 30;

    /**
     * The key for the roles storage
     */
    public static final String CLAIMS_ROLES_KEY = "roles";

    /**
     * The key for the cookie storage
     */
    public static final String COOKIE_NAME = "PayCrypt";

    /**
     * Prefix of the bearer token
     */
    public static final String TOKEN_PREFIX = "Bearer ";
}
