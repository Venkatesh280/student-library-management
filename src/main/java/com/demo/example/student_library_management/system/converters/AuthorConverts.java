package com.demo.example.student_library_management.system.converters;

import com.demo.example.student_library_management.system.model.Author;
import com.demo.example.student_library_management.system.model.Card;
import com.demo.example.student_library_management.system.requestdto.AuthorRequestDto;
import com.demo.example.student_library_management.system.requestdto.CardRequestDto;

public class AuthorConverts {

    //converts AuthorRequestDto  into AuthorConverts class

    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto) {
        Author author = Author.builder()
                .name(authorRequestDto.getName())
                .gender(authorRequestDto.getGender())
                .country(authorRequestDto.getCountry())
                .rating(authorRequestDto.getRating())
                .build();
        return author;
    }
}
