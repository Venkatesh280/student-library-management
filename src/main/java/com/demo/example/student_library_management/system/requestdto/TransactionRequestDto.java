package com.demo.example.student_library_management.system.requestdto;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.resource.transaction.spi.TransactionStatus;

@Data

public class TransactionRequestDto {


    private TransactionStatus transactionStatus;
    private double fine;
    private boolean isIssueOrReturn;
    private String dueDate;
    private int authorId;
    private int cardId;
}
