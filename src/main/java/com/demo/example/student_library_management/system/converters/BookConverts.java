package com.demo.example.student_library_management.system.converters;

import com.demo.example.student_library_management.system.model.Book;
import com.demo.example.student_library_management.system.requestdto.BookRequestDto;


public class BookConverts {

    //converts bookRequestDto  into book  class

    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto) {
        Book book = Book.builder()
                .name(bookRequestDto.getName())
                .pages(bookRequestDto.getPages())
                .publisherName(bookRequestDto.getPublisherName())
                .genre(bookRequestDto.getGenre())
                .available(bookRequestDto.isAvailable())
                .build();
        return book;
    }

    }

