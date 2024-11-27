package com.demo.example.student_library_management.system.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor //paramaetrized constructor
@NoArgsConstructor //default constructor
public class Student {

    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String dob;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String sem;


}
