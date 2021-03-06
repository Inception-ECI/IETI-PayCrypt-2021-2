package com.inception.paycrypt.testutils;

import com.inception.paycrypt.dto.UserDto;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.utils.Country;
import com.inception.paycrypt.utils.DocumentType;
import com.inception.paycrypt.utils.UserRoles;
import com.inception.paycrypt.utils.UserState;

/**
 * Util Class used for test
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class UserUtils {

	/**
	 * Method to get a valid {@link UserDto}, using the password ContraseñaTest
	 *
	 * @return A new {@link User}
	 */
	public static UserDto getValidActiveUserDto() {

		return UserDto.builder()
					  .documentType(DocumentType.CC)
					  .documentNumber(123456789)
					  .email("test.email@test.com")
					  .password("$2a$10$C3N8E7v.Ln3a/NNLtEe/8elRsf32ZByO2.XbiuaKfnRnwJwo66Ko6")
					  .userState(UserState.ACTIVE)
					  .phone("3174414410")
					  .country(Country.CO)
					  .name("Test")
					  .lastName("Test")
					  .build();
	}

	/**
	 * Method to get a valid {@link User}
	 *
	 * @return A new {@link User}
	 */
	public static User getValidActiveUser() {

		return User.builder()
				   .id("613d5e23808c0a040d57de91")
				   .documentType(DocumentType.CC)
				   .documentNumber(123456789)
				   .email("test.email@test.com")
				   .password("$2a$10$C3N8E7v.Ln3a/NNLtEe/8elRsf32ZByO2.XbiuaKfnRnwJwo66Ko6")
				   .role(UserRoles.USER)
				   .userState(UserState.ACTIVE)
				   .phone("3174414410")
				   .country(Country.CO)
				   .name("Test")
				   .lastName("Test")
				   .build();
	}

}
