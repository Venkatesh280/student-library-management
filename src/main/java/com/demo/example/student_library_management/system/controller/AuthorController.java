package com.demo.example.student_library_management.system.controller;


import com.demo.example.student_library_management.system.model.Author;
import com.demo.example.student_library_management.system.requestdto.AuthorRequestDto;
import com.demo.example.student_library_management.system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Author/api")
public class AuthorController {


    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
      String response=authorService.addAuthor(authorRequestDto);
      return response;

    }
}
