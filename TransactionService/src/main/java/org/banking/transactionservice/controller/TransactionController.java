package org.banking.transactionservice.controller;


import org.banking.transactionservice.entity.Account;
import org.banking.transactionservice.entity.Account111;
import org.banking.transactionservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private AccountRepository accountRepository;

    public TransactionController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @GetMapping
    public String test(){
        return "TransactionController";
    }


    @GetMapping("/getAccount/{id}")
    public Account getAccounts(@PathVariable("id") String id){
        return accountRepository.findById(id).get();
    }
}
