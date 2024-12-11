package org.banking.transactionservice.repository;


import org.banking.transactionservice.entity.Account;
import org.banking.transactionservice.entity.Account111;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, String> {
}
