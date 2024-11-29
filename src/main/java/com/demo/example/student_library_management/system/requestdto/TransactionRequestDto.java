package com.demo.example.student_library_management.system.requestdto;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import com.demo.example.student_library_management.system.enums.TransactionStatus;
import jakarta.persistence.Column;

@Data
public class TransactionRequestDto {
    private TransactionStatus transactionStatus;
    private double fine;
    private boolean issueOrReturn;
    private String dueDate;
    private int cardId;
    private int bookId;
}
