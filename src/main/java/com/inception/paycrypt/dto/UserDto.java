package com.inception.paycrypt.dto;

import com.inception.paycrypt.utils.Country;
import com.inception.paycrypt.utils.DocumentType;
import com.inception.paycrypt.utils.State;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mapping class for the User class
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
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
	 * The user password hashed
	 */
	private String password;

	/**
	 * The user state
	 */
	private State state;

	/**
	 * The user phone
	 */
	private String phone;

	/**
	 * The user country
	 */
	private Country country;

}