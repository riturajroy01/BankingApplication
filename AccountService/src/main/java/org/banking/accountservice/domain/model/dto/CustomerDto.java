package org.banking.accountservice.domain.model.dto;


import lombok.Builder;
import org.banking.accountservice.domain.entity.Account;
import java.util.Set;

@Builder
public class CustomerDto {

    private String id;

    private String name;

    private String surname;

    private Set<Account> account;
}
