package com.demo.example.student_library_management.system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.resource.transaction.spi.TransactionStatus;
import com.demo.example.student_library_management.system.enums.TransactionStatus;

import java.util.Date;


@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="transaction_status",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name="transaction_date",nullable = false)
    @CreationTimestamp
    private Date transactionDate;

    @Column(nullable=false)
    private double fine;

    @Column(name="is_issue_or_return",nullable = false)
    private boolean issueOrReturn;

    @Column(name="due_date")
    private String dueDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;
}
