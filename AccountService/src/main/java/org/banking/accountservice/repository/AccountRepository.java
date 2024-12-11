package org.banking.accountservice.repository;

import org.banking.accountservice.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, String> {
}
