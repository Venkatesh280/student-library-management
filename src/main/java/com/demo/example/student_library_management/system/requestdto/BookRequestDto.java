package com.demo.example.student_library_management.system.requestdto;

import com.demo.example.student_library_management.system.enums.Genre;
import lombok.Data;

@Data
public class BookRequestDto {

    private String name;
    private int pages;
    private String publisherName;
    private Genre genre;
    private boolean isAvailable;
    private int authorId;
    private int bookId;
}
