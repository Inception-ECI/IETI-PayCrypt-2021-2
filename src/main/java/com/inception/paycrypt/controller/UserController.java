package com.inception.paycrypt.controller;

import com.inception.paycrypt.dto.UserDto;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

	/**
	 * The {@link UserService}
	 */
	private final UserService userService;

	/**
	 * Post create endpoint
	 *
	 * @param userDto The {@link UserDto} to be saved
	 * @return The {@link User} saved in the server
	 */
	@PostMapping
	public ResponseEntity<User> create(@RequestBody UserDto userDto) {

		return ResponseEntity.ok(userService.create(userDto));
	}

	/**
	 * Put update endpoint for general information
	 *
	 * @param userDto The {@link UserDto} to be updated
	 * @param id      The {@link User} id to be updated
	 * @return The {@link User} after being updated
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id) {

		return ResponseEntity.ok(userService.updateUserInfo(userDto, id));
	}

	/**
	 * Put update endpoint for password changes
	 *
	 * @param userDto The {@link UserDto} to be updated
	 * @param id      The {@link User} id to be updated
	 * @return The {@link User} after being updated
	 */
	@PutMapping("/password/{id}")
	public ResponseEntity<User> updatePassword(@RequestBody UserDto userDto, @PathVariable String id) {

		return ResponseEntity.ok(userService.updatePassword(id, userDto.getNewPassword(), userDto.getPassword()));
	}

}
