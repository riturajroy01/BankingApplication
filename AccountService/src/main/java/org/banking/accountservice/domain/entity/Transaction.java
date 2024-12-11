package org.banking.accountservice.domain.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.util.Objects;


@Data
@Entity
/*@NoArgsConstructor
@AllArgsConstructor*/
public class Transaction {

    @Id
  /*  @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")*/
    private String id;

    @Column(nullable = false)
    private BigDecimal amount;

 /*   @Column(nullable = false)
    private LocalDateTime transactionDate;*/

    public Transaction() {
    }

    @Column
    private String transactionDate;

    @ManyToOne(/*fetch = FetchType.EAGER,*/ optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    Account account;

    public Transaction(BigDecimal amount, String transactionDate, Account account) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account = account;
    }

    public Transaction(String id, BigDecimal amount, String transactionDate, Account account) {
        this.id = id;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account = account;
    }
}
