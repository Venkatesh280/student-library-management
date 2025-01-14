package com.demo.example.student_library_management.system.service;

import com.demo.example.student_library_management.system.converters.BookConverts;
import com.demo.example.student_library_management.system.model.Author;
import com.demo.example.student_library_management.system.model.Book;
import com.demo.example.student_library_management.system.model.Card;
import com.demo.example.student_library_management.system.repository.AuthorRepository;
import com.demo.example.student_library_management.system.repository.BookRepository;
import com.demo.example.student_library_management.system.repository.CardRepository;
import com.demo.example.student_library_management.system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){

        Book book = BookConverts.convertBookRequestDtoIntoBook(bookRequestDto);

        // from authorId get whole author details
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);
        // from cardId get whole card details
        Card card = cardRepository.findById(bookRequestDto.getCardId()).get();
        book.setCard(card);

        bookRepository.save(book);
        return "Book Saved into database";
    }
}
