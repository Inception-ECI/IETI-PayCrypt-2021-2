package com.inception.paycrypt.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Security configuration class
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableWebSecurity
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Configuration method
	 *
	 * @param http HttpSecurity to be configured
	 * @throws Exception Throws a {@link Exception}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/v1/health").permitAll()
			.antMatchers(HttpMethod.POST, "/v1/user/**").permitAll()
			.antMatchers(HttpMethod.PUT, "/v1/user/**").permitAll()
			.antMatchers(HttpMethod.POST, "/v1/conversion/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
