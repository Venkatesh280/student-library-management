package com.demo.example.student_library_management.system.requestdto;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.resource.transaction.spi.TransactionStatus;
import com.demo.example.student_library_management.system.enums.TransactionStatus;


@Data

public class TransactionRequestDto {


    private TransactionStatus transactionStatus;
    private double fine;
    private boolean issueOrReturn;
    private String dueDate;
    private int bookId;
    private int cardId;
}
