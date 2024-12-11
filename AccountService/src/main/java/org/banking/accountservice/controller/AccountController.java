package org.banking.accountservice.controller;


import org.banking.accountservice.domain.CreateAccountRequest;
import org.banking.accountservice.domain.entity.Account;
import org.banking.accountservice.service.AccountService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody CreateAccountRequest createAccountRequest) throws ChangeSetPersister.NotFoundException {

        return accountService.createAccount(createAccountRequest);

    }

/*    @GetMapping("/getAll")
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }*/


}
