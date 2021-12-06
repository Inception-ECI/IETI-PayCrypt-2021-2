package com.inception.paycrypt.controller;

import com.inception.paycrypt.model.Transaction;
import com.inception.paycrypt.service.TransactionService;
import com.inception.paycrypt.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

import java.util.List;

import static com.inception.paycrypt.utils.UserRoles.MERCHANT;

/**
 * Transaction Controller
 *
 * @author Andres Calderon (andres.calderon@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/transaction")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactionsByUserid(@RequestHeader("Authorization") String authorization) {

        return ResponseEntity.ok(transactionService.getAllTransactionsByUserid(TokenUtils.extractUserId(authorization.split(" ")[1])));
    }

}
