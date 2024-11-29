package com.demo.example.student_library_management.system.requestdto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorRequestDto {

    private String name;
    private String gender;
    private String country;
    private double rating;
}
