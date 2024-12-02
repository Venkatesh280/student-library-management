package com.demo.example.student_library_management.system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor //paramaetrized constructor
@NoArgsConstructor //default constructor
@Builder // it helps to build object
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

    @JsonManagedReference
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)//when create in student data automatically in card table do this operations in cascadetype any modifys in student table automatically update in card taable
    private Card card;

}
