package org.banking.accountservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
/*@Table(name = "account")*/
public class Account {

    @Id
   /* @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")*/
    private String id;

    @Column(nullable = false)
    private BigDecimal initialCredit = BigDecimal.ZERO;

  /*  @Column(nullable = false)
    private LocalDateTime startDate;*/


    @Column
      private String startDate;

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)*/
    @ManyToOne(/*fetch = FetchType.EAGER,*/ cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @OneToMany(mappedBy = "account", /*fetch = FetchType.EAGER,*/ cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(BigDecimal initialCredit, String startDate, Customer customer) {

        this.initialCredit = initialCredit;
        this.startDate = startDate;
        this.customer = customer;
    }

    public Account(String id, BigDecimal initialCredit, String startDate, Customer customer, List<Transaction> transactions) {
        this.id = id;
        this.initialCredit = initialCredit;
        this.startDate = startDate;
        this.customer = customer;
        this.transactions = transactions;
    }
}
