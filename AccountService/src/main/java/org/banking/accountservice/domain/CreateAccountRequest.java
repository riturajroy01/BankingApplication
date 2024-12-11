package org.banking.accountservice.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountRequest {

    String customerID;

    BigDecimal initialCredit;
}
