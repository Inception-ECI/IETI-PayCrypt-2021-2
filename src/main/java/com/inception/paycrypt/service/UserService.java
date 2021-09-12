package com.inception.paycrypt.service;

import com.inception.paycrypt.dto.UserDto;
import com.inception.paycrypt.model.User;
import org.springframework.stereotype.Service;

/**
 * Define the signature to implement a User Service
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface UserService {

	/**
	 * Create a user
	 *
	 * @param user The {@link User} to be created in the records
	 * @return The user that is now in the records
	 */
	User create(final UserDto userDto);

	/**
	 * Find a User using his email
	 *
	 * @param email The email that is going to be used to search the User
	 * @return The {@link User} that has been found
	 */
	User findByEmail(final String email);

	/**
	 * Update a user if given the User id
	 *
	 * @param userDto The {@link User} with the new information
	 * @param id      The id of the {@link User} to be Updated
	 * @return The {@link User} that has been Updated
	 */
	User updateUserInfo(final UserDto userDto, final String id);

	/**
	 * @param id          The id of the {@link User} to be Updated
	 * @param newPassword The new password to be set to the user
	 * @param oldPassword The old password of the user
	 * @return The {@link User} that has been Updated
	 */
	User updatePassword(final String id, final String newPassword, final String oldPassword);

}
