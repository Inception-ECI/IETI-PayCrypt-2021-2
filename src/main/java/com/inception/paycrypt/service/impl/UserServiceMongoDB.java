package com.inception.paycrypt.service.impl;

import java.util.Optional;

import com.inception.paycrypt.dto.UserDto;
import com.inception.paycrypt.exception.UserServiceException;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.repository.UserRepository;
import com.inception.paycrypt.service.UserService;
import com.inception.paycrypt.utils.UserState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Define the signature to implement a {@link UserService} using MongoDB
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("userServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceMongoDB implements UserService {

	/**
	 * MongoDB repository where the information is going to be extracted
	 */
	private final UserRepository userRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User create(final UserDto userDto) {

		return userRepository.save(new User(userDto));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findByEmail(final String email) {

		Optional<User> optionalUser = userRepository.findByEmail(email);

		if (optionalUser.isPresent()) {

			return optionalUser.get();
		}

		throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User updateUserInfo(final UserDto userDto, final String id) {

		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.updateUserInfo(userDto);
			userRepository.save(user);
			return user;
		}

		throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User updatePassword(final String id, final String newPassword, final String oldPassword) {

		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			boolean canChangePassword = user.updatePassword(newPassword, oldPassword);

			if (canChangePassword) {
				userRepository.save(user);

				return user;
			}

			throw new UserServiceException(UserServiceException.PASSWORD_DONT_MATCH);
		}

		throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User updateState(final String id, final UserState userState) {

		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.updateState(userState);
			userRepository.save(user);

			return user;
		}

		throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
	}

}
