package com.inception.paycrypt.controller;

import javax.annotation.security.RolesAllowed;

import com.inception.paycrypt.dto.CurrencyDto;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.service.CurrencyService;
import com.inception.paycrypt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Currency Controller
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/currency")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrencyController {

	/**
	 * Admin Role for Private endpoint
	 */
	private static final String ADMIN_ROLE = "Administrator";

	/**
	 * The {@link UserService}
	 */
	private final CurrencyService currencyService;

	/**
	 * Currency create endpoint
	 *
	 * @param currencyDto The {@link CurrencyDto} to be saved
	 * @return The {@link Currency} saved in the server
	 */
	@PostMapping
	@RolesAllowed(ADMIN_ROLE)
	public ResponseEntity<Currency> create(@RequestBody CurrencyDto currencyDto) {

		return ResponseEntity.ok(currencyService.create(currencyDto));
	}

	/**
	 * Currency update endpoint
	 *
	 * @param currencyDto The {@link CurrencyDto} to be updated
	 * @param id          The {@link Currency} id to be updated
	 * @return The {@link Currency} after being updated
	 */
	@PutMapping("/{id}")
	@RolesAllowed(ADMIN_ROLE)
	public ResponseEntity<Currency> update(@RequestBody CurrencyDto currencyDto, @PathVariable String id) {

		return ResponseEntity.ok(currencyService.update(currencyDto, id));
	}

	/**
	 * Currency delete endpoint
	 *
	 * @param id The {@link Currency} id to be deleted
	 * @return If the {@link Currency} has been deleted
	 */
	@DeleteMapping("/{id}")
	@RolesAllowed(ADMIN_ROLE)
	public ResponseEntity<Boolean> delete(@PathVariable String id) {

		currencyService.deleteById(id);

		return ResponseEntity.ok(true);
	}

}
