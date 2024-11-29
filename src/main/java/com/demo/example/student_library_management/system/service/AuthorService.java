package com.demo.example.student_library_management.system.service;


import com.demo.example.student_library_management.system.converters.AuthorConverts;
import com.demo.example.student_library_management.system.model.Author;
import com.demo.example.student_library_management.system.repository.AuthorRepository;
import com.demo.example.student_library_management.system.requestdto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String addAuthor(AuthorRequestDto authorRequestDto) {
      Author author= AuthorConverts.convertAuthorRequestDtoIntoAuthor(authorRequestDto);
      authorRepository.save(author);
      return "Author saved successfully";
    }
}
