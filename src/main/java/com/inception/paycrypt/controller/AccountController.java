package com.inception.paycrypt.controller;

import com.inception.paycrypt.dto.AccountDto;
import com.inception.paycrypt.model.Account;
import com.inception.paycrypt.service.AccountService;
import com.inception.paycrypt.utils.AccountState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

import static com.inception.paycrypt.utils.UserRoles.ADMIN;
import static com.inception.paycrypt.utils.UserRoles.USER;

/**
 * Account Controller
 *
 * @author Paula Guevara
 * @version 1.0.0
 * @since 1.0.0
 */

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {

    /**
     * The {@link AccountService}
     */
    private final AccountService accountService;

    /**
     * Method to get the account by id
     * @param id The {@link AccountDto} to be saved
     * @return Returns https response if the id was found or not
     */
    @GetMapping( "/{id}" )
    public ResponseEntity<Account> findById (@PathVariable  String id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(accountService.findById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        }
    }

    /**
     * Account create endpoint
     * @param accountDto The {@link AccountDto} to be saved
     * @return The {@link Account} saved in the server
     */
    @PostMapping
    @RolesAllowed(USER)
    public ResponseEntity<Account> create (@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.create(accountDto));
    }


    /**
     * Account update endpoint
     * @param accountDto The {@link AccountDto} to be updated
     * @param id The The {@link Account} id to be updated
     * @return The {@link Account} after being updated
     */
    @PutMapping("/{id}")
    @RolesAllowed({ADMIN})
    public ResponseEntity<Account> updateAccount (@RequestBody AccountDto accountDto, @PathVariable String id){
        return ResponseEntity.ok(accountService.updateAccount(accountDto, id));
    }

    /**
     * Account update endpoint
     * @param accountDto The {@link AccountDto} to be updated
     * @param balance The The {@link Account} id to be updated
     * @return The {@link Account} after being updated
     */
    @PutMapping("/{balance}")
    @RolesAllowed({USER})
    public ResponseEntity<Account> updateBalance (@RequestBody AccountDto accountDto, @PathVariable String balance){
        return ResponseEntity.ok(accountService.updateBalance(accountDto, balance));
    }

    /**
     * Account update endpoint
     * @param accountDto The {@link AccountDto} to be updated
     * @param state The The {@link Account} id to be updated
     * @return The {@link Account} after being updated
     */
    @PutMapping("/{state}")
    @RolesAllowed({USER})
    public ResponseEntity<Account> updateState (@RequestBody AccountDto accountDto, @PathVariable AccountState state){
        return ResponseEntity.ok(accountService.updateState(accountDto, state));
    }

    /**
     * Account delete endpoint
     * @param id The {@link Account} id to be deleted
     * @return if the {@link Account} has been deleted
     */
    @DeleteMapping("/{id}")
    @RolesAllowed(ADMIN)
    public  ResponseEntity<Boolean> delete(@PathVariable String id){
        try{
            accountService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Boolean.FALSE);

        }
    }
}
