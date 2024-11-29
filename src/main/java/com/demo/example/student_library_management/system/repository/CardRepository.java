package com.demo.example.student_library_management.system.repository;

import com.demo.example.student_library_management.system.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
