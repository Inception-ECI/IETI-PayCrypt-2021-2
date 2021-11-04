package com.inception.paycrypt.controller;

import com.inception.paycrypt.dto.AccountDto;
import com.inception.paycrypt.model.Account;
import com.inception.paycrypt.service.AccountService;
import com.inception.paycrypt.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

import static com.inception.paycrypt.utils.UserRoles.*;

import java.util.List;

/**
 * Account Controller
 *
 * @author Paula Guevara
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@CrossOrigin(originPatterns = "*", origins = "*")
@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {

    /**
     * The {@link AccountService}
     */
    private final AccountService accountService;

    /**
     * Account create endpoint
     *
     * @param accountDto The {@link AccountDto} to be saved
     * @return The {@link Account} saved in the server
     */
    @PostMapping
    @RolesAllowed({USER, MERCHANT})
    public ResponseEntity<Account> create(@RequestBody AccountDto accountDto, @RequestHeader("Authorization") String authorization) {
        accountDto.setUserId(TokenUtils.extractUserId(authorization.split(" ")[1]));
        return ResponseEntity.ok(accountService.create(accountDto));
    }

    /**
     * Get all account from the logged user
     *
     * @return The list of {@link Account} saved in the server
     */
    @GetMapping("/all")
    @RolesAllowed({USER, MERCHANT})
    public ResponseEntity<List<Account>> getAllAccounts(@RequestHeader("Authorization") String authorization) {

        return ResponseEntity.ok(accountService.getAllAccountsByUserid(TokenUtils.extractUserId(authorization.split(" ")[1])));
    }

    /**
     * Account state update endpoint
     *
     * @param accountDto The {@link AccountDto} to be updated
     * @param accountId  The The {@link Account} id to be updated
     * @return The {@link Account} after being updated
     */
    @PutMapping("/{accountId}")
    @RolesAllowed({USER, MERCHANT})
    public ResponseEntity<Account> updateState(@RequestBody AccountDto accountDto, @PathVariable String accountId, @RequestHeader("Authorization") String authorization) {

        return ResponseEntity.ok(accountService.updateState(accountId, accountDto.getState(), authorization.split(" ")[1]));
    }

    /**
     * Account delete endpoint
     *
     * @param accountId The {@link Account} id to be deleted
     * @return if the {@link Account} has been deleted
     */
    @DeleteMapping("/{accountId}")
    @RolesAllowed({USER, MERCHANT})
    public ResponseEntity<Boolean> delete(@PathVariable String accountId) {
        accountService.deleteById(accountId);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
