package com.demo.example.student_library_management.system.controller;


import com.demo.example.student_library_management.system.model.Student;
import com.demo.example.student_library_management.system.requestdto.StudentRequestDto;
import com.demo.example.student_library_management.system.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
      String response= studentService.addStudent(studentRequestDto);
      return response;
    }
}
