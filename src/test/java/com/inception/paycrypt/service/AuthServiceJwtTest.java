package com.inception.paycrypt.service;

import static com.inception.paycrypt.testutils.UserUtils.getValidActiveUser;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import javax.xml.bind.DatatypeConverter;

import com.inception.paycrypt.dto.TokenDto;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.service.impl.AuthServiceJwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the {@link AuthServiceJwtTest} class
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
class AuthServiceJwtTest {

	/**
	 * Class to be tested
	 */
	private AuthServiceJwt authServiceJwt;

	/**
	 * Secret used for testing
	 */
	private static final String JWT_TEST_SECRET = "Test Secret";

	@BeforeEach()
	void setUp() {

		authServiceJwt = new AuthServiceJwt();
		authServiceJwt.setJwtSecret(JWT_TEST_SECRET);
	}

	@Test
	void shouldCreate_validToken() {

		User user = getValidActiveUser();
		TokenDto token = authServiceJwt.generateToken(user);
		Claims claims = decodeTokenJwt(token.getToken());
		assertAll(
				() -> assertEquals(claims.getSubject(), user.getId()),
				() -> assertTrue(claims.getExpiration().after(new Date())),
				() -> assertTrue(claims.getIssuedAt().before(new Date())));

	}

	/**
	 * Method to decode a JWT token
	 *
	 * @param jwt The JWT String token to be decoded
	 * @return The Jwt token Decoded
	 */
	private Claims decodeTokenJwt(String jwt) {

		return Jwts.parser()
				   .setSigningKey(DatatypeConverter.parseBase64Binary(JWT_TEST_SECRET))
				   .parseClaimsJws(jwt).getBody();
	}

}
