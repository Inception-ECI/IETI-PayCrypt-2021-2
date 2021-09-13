package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.Country;
import com.inception.paycrypt.utils.DocumentType;
import com.inception.paycrypt.utils.UserState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mapping class for the User class
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.1.0
 * @since 1.0.0
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	/**
	 * The user document type
	 */
	private DocumentType documentType;

	/**
	 * The user document number
	 */
	private int documentNumber;

	/**
	 * The user email
	 */
	private String email;

	/**
	 * The user current password hashed
	 */
	private String password;

	/**
	 * The user possible new password hashed
	 */
	private String newPassword;

	/**
	 * The user state
	 */
	private UserState userState;

	/**
	 * The user phone
	 */
	private String phone;

	/**
	 * The user country
	 */
	private Country country;

	/**
	 * The user name
	 */
	private String name;

	/**
	 * The user lastname
	 */
	private String lastName;

}
