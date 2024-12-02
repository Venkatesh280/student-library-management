package com.demo.example.student_library_management.system.service;


import com.demo.example.student_library_management.system.converters.TransactionConvertor;
import com.demo.example.student_library_management.system.model.Book;
import com.demo.example.student_library_management.system.model.Card;
import com.demo.example.student_library_management.system.model.Transaction;
import com.demo.example.student_library_management.system.repository.BookRepository;
import com.demo.example.student_library_management.system.repository.CardRepository;
import com.demo.example.student_library_management.system.repository.TransactionRepository;
import com.demo.example.student_library_management.system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    public String addTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = TransactionConvertor.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);

        Card card = cardRepository.findById(transactionRequestDto.getCardId()).get();
        transaction.setCard(card);

        Book book = bookRepository.findById(transactionRequestDto.getBookId()).get();
        transaction.setBook(book);

        transactionRepository.save(transaction);
        return "Transaction added successfully";
    }
}
