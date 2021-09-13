package com.inception.paycrypt.testutils;

import com.inception.paycrypt.dto.UserDto;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.utils.Country;
import com.inception.paycrypt.utils.DocumentType;
import com.inception.paycrypt.utils.UserState;

public class UserDtoUtils {

	public static UserDto getValidActiveUserDto() {

		return UserDto.builder()
					  .documentType(DocumentType.CC)
					  .documentNumber(123456789)
					  .email("test.email@test.com")
					  .password("ContraseñaTest")
					  .userState(UserState.ACTIVE)
					  .phone("3174414410")
					  .country(Country.CO)
					  .name("Test")
					  .lastName("Test")
					  .build();
	}

	public static User getValidActiveUser() {

		return User.builder()
				   .id("613d5e23808c0a040d57de91")
				   .documentType(DocumentType.CC)
				   .documentNumber(123456789)
				   .email("test.email@test.com")
				   .password("ContraseñaTest")
				   .userState(UserState.ACTIVE)
				   .phone("3174414410")
				   .country(Country.CO)
				   .name("Test")
				   .lastName("Test")
				   .build();
	}

}
