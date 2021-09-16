package com.inception.paycrypt.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum class for users roles
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public final class UserRoles {

	/**
	 * Administration Role
	 */
	public static final String ADMIN = "Administrator";

	/**
	 * User role
	 */
	public static final String USER = "User";

	/**
	 * Merchant role
	 */
	public static final String MERCHANT = "Merchant";

}
