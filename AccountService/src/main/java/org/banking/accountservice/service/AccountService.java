package org.banking.accountservice.service;

import lombok.Builder;
import org.banking.accountservice.domain.CreateAccountRequest;
import org.banking.accountservice.domain.entity.Account;
import org.banking.accountservice.domain.entity.Customer;
import org.banking.accountservice.domain.entity.Transaction;
import org.banking.accountservice.repository.AccountRepository;
import org.banking.accountservice.repository.CustomerRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public class AccountService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public AccountService(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }
    @Transactional
    public Account createAccount(CreateAccountRequest createAccountRequest) throws ChangeSetPersister.NotFoundException {

        Customer customer = customerRepository.findById(createAccountRequest.getCustomerID())
                        .orElseThrow(
                                ChangeSetPersister.NotFoundException::new);


        Account account = new Account("1",createAccountRequest.getInitialCredit(), "",customer, new ArrayList<>());
       // account.setCustomer(customer);
       // account.setInitialCredit(createAccountRequest.getInitialCredit());
        //account.setStartDate(LocalDateTime.now());

        //if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction("1",createAccountRequest.getInitialCredit(),"",account);
           // transaction.setAmount(createAccountRequest.getInitialCredit());
            //transaction.setTransactionDate(LocalDateTime.now());
            //transaction.setAccount(account);

            account.getTransactions().add(transaction);
            //account.setTransactions(new HashSet<>(transaction));

       // }

        return accountRepository.save(account);

    }
}
