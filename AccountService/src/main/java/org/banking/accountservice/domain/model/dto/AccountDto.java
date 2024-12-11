package org.banking.accountservice.domain.model.dto;

import lombok.Builder;
import lombok.Data;
import org.banking.accountservice.domain.entity.Customer;
import org.banking.accountservice.domain.entity.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
public class AccountDto {

    private String id;

    private BigDecimal initialCredit;

    private LocalDateTime startDate;

    private Customer customer;

    private Set<Transaction> transactions;
}
