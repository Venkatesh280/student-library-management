package com.demo.example.student_library_management.system.converters;

import com.demo.example.student_library_management.system.model.Transaction;
import com.demo.example.student_library_management.system.requestdto.TransactionRequestDto;

public class TransactionConvertor {

    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = Transaction.builder()
                .transactionStatus(transactionRequestDto.getTransactionStatus())
                .dueDate(transactionRequestDto.getDueDate())
                .isIssueOrReturn(transactionRequestDto.isIssueOrReturn())
                .fine(transactionRequestDto.getFine())
                .build();
        return transaction;
    }
}
