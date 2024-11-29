package com.demo.example.student_library_management.system.repository;

import com.demo.example.student_library_management.system.model.Book;
import com.demo.example.student_library_management.system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}