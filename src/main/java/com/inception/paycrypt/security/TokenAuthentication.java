package com.inception.paycrypt.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapping of the token authentication parameters
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class TokenAuthentication extends AbstractAuthenticationToken {

    /**
     * The token for the authenticated user
     */
    String token;

    /**
     * The principal of the authenticated user
     */
    String subject;

    /**
     * The roles of the authenticated user
     */
    List<String> roles;

    /**
     * Constructor
     *
     * @param token The token for the authenticated user
     * @param subject The principal of the authenticated user
     * @param roles The roles of the authenticated user
     */
    public TokenAuthentication(String token, String subject, List<String> roles) {
        super(null);
        this.token = token;
        this.subject = subject;
        this.roles = roles;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAuthenticated() {
        return !token.isEmpty() && !subject.isEmpty() && !roles.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getCredentials() {
        return token;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getPrincipal() {
        return subject;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
    }
}
