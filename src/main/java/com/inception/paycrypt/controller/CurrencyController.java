package com.inception.paycrypt.controller;

import static com.inception.paycrypt.utils.UserRoles.ADMIN;

import javax.annotation.security.RolesAllowed;

import com.inception.paycrypt.dto.CurrencyDto;
import com.inception.paycrypt.model.Currency;
import com.inception.paycrypt.service.CurrencyService;
import com.inception.paycrypt.service.UserService;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Currency Controller
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/currency")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrencyController {

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
	@RolesAllowed(ADMIN)
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
	@RolesAllowed(ADMIN)
	public ResponseEntity<Currency> update(@RequestBody CurrencyDto currencyDto, @PathVariable String id) {

		return ResponseEntity.ok(currencyService.update(currencyDto, CurrencyCode.valueOf(id)));
	}

	/**
	 * Currency delete endpoint
	 *
	 * @param id The {@link Currency} id to be deleted
	 * @return If the {@link Currency} has been deleted
	 */
	@DeleteMapping("/{id}")
	@RolesAllowed(ADMIN)
	public ResponseEntity<Boolean> delete(@PathVariable String id) {

		currencyService.deleteByCurrencyCode(CurrencyCode.valueOf(id));

		return ResponseEntity.ok(true);
	}

}
