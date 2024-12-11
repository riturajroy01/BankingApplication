package org.banking.accountservice.domain.model.dto;

import lombok.Builder;
import org.banking.accountservice.domain.entity.Account;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public class TransactionDto {

    private String id;

    private BigDecimal amount;

    private LocalDateTime transactionDate;

}
