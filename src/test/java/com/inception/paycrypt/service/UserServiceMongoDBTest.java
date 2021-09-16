package com.inception.paycrypt.service;

import static com.inception.paycrypt.testutils.UserDtoUtils.getValidActiveUser;
import static com.inception.paycrypt.testutils.UserDtoUtils.getValidActiveUserDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inception.paycrypt.exception.UserServiceException;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.repository.UserRepository;
import com.inception.paycrypt.service.impl.UserServiceMongoDB;
import com.inception.paycrypt.utils.Country;
import com.inception.paycrypt.utils.DocumentType;
import com.inception.paycrypt.utils.UserState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Test class for the {@link UserServiceMongoDB} class
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class UserServiceMongoDBTest {

	/**
	 * Class to be tested
	 */
	private UserServiceMongoDB userServiceMongoDB;

	/**
	 * MongoDB Repository mock
	 */
	@Mock
	private UserRepository userRepository;

	@BeforeEach()
	void setUp() {

		userServiceMongoDB = new UserServiceMongoDB(userRepository);
	}

	@Test
	void shouldCreate_aNewUserInTheDatabase() {

		userServiceMongoDB.create(getValidActiveUserDto());
		verify(userRepository).save(any(User.class));
	}

	@Test
	void shouldFindAnActiveUser_givenAnEmail() {

		when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(getValidActiveUser()));

		assertThat(userServiceMongoDB.findByEmail("test.email@test.com"))
				.satisfies(user -> {
					assertThat(user).isNotNull();
					assertThat(user.getId()).isNotNull();
					assertThat(user.getDocumentType()).isEqualTo(DocumentType.CC);
					assertThat(user.getEmail()).contains("@");
					assertThat(user.getPassword()).isNotNull();
					assertThat(user.getUserState()).isEqualTo(UserState.ACTIVE);
					assertThat(user.getPhone()).isNotNull();
					assertThat(user.getCountry()).isEqualTo(Country.CO);
					assertThat(user.getName()).isNotNull();
					assertThat(user.getLastName()).isNotNull();
				});

	}

	@Test
	void whenUserIsNotPresent_shouldThrow_UserNotFoundException() {

		when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

		UserServiceException userServiceException = assertThrows(UserServiceException.class, () -> {
			userServiceMongoDB.findByEmail("test.email@test.com");
		});

		assertEquals(UserServiceException.USER_NOT_FOUND, userServiceException.getServerErrorResponseDto().getMessage());
	}

	@Test
	void whenValidUpdate_shouldUpdateUser_normalInformation() {

		when(userRepository.findById(anyString())).thenReturn(Optional.of(getValidActiveUser()));

		userServiceMongoDB.updateUserInfo(getValidActiveUserDto(), "613d5e23808c0a040d57de91");
		verify(userRepository).save(any(User.class));
	}

	@Test
	void whenUserIdIsNotPresent_shouldThrow_UserNotFoundException() {

		when(userRepository.findById(anyString())).thenReturn(Optional.empty());

		UserServiceException userServiceException = assertThrows(UserServiceException.class, () -> {
			userServiceMongoDB.updateUserInfo(getValidActiveUserDto(), "123456789");
		});

		assertEquals(UserServiceException.USER_NOT_FOUND, userServiceException.getServerErrorResponseDto().getMessage());
	}

	@Test
	void whenValidUpdatePassword_shouldUpdateUser_passwordInformation() {

		when(userRepository.findById(anyString())).thenReturn(Optional.of(getValidActiveUser()));

		userServiceMongoDB.updatePassword("613d5e23808c0a040d57de91", "newPassword", "ContraseñaTest");
		verify(userRepository).save(any(User.class));
	}

	@Test
	void whenUpdatePasswordAnd_UserIsNotPresent_shouldThrow_UserNotFoundException() {

		when(userRepository.findById(anyString())).thenReturn(Optional.empty());

		UserServiceException userServiceException = assertThrows(UserServiceException.class, () -> {
			userServiceMongoDB.updatePassword("123456789", "newPassword", "ContraseñaTest");
		});

		assertEquals(UserServiceException.USER_NOT_FOUND, userServiceException.getServerErrorResponseDto().getMessage());
	}

	@Test
	void whenUpdatePasswordAnd_passwordDontMatch_shouldThrow_PasswordDontMatchException() {

		when(userRepository.findById(anyString())).thenReturn(Optional.of(getValidActiveUser()));

		UserServiceException userServiceException = assertThrows(UserServiceException.class, () -> {
			userServiceMongoDB.updatePassword("123456789", "newPassword", "oldPassword");
		});

		assertEquals(UserServiceException.PASSWORD_DONT_MATCH, userServiceException.getServerErrorResponseDto().getMessage());
	}

	@Test
	void whenValidStateUpdate_shouldUpdateUser_stateInformation() {

		when(userRepository.findById(anyString())).thenReturn(Optional.of(getValidActiveUser()));

		userServiceMongoDB.updateState("613d5e23808c0a040d57de91", UserState.DISABLED);
		verify(userRepository).save(any(User.class));
	}

	@Test
	void whenUpdateStateAnd_userIsNotPresent_shouldThrow_PasswordDontMatchException() {

		when(userRepository.findById(anyString())).thenReturn(Optional.empty());

		UserServiceException userServiceException = assertThrows(UserServiceException.class, () -> {
			userServiceMongoDB.updateState("613d5e23808c0a040d57de91", UserState.DISABLED);
		});

		assertEquals(UserServiceException.USER_NOT_FOUND, userServiceException.getServerErrorResponseDto().getMessage());
	}

}
