package org.banking.transactionservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account111 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(unique = true, nullable = false)
    String accountNumber;
    @Column(nullable = false)
    String accountType;
    @Column(nullable = false)
    String accountHolderName;
}
