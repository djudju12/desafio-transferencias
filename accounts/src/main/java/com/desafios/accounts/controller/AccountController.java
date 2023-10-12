package com.desafios.accounts.controller;

import com.desafios.accounts.model.AccountDTO;
import com.desafios.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/accounts")
@RestController
@AllArgsConstructor
public class AccountController {

//    private AccountService accService;

    @GetMapping(value = "/{accountId}", produces = "application/json")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable String accountId) {
  //      return ResponseEntity.ok(accService.getAccount(accountId));
    }
}
