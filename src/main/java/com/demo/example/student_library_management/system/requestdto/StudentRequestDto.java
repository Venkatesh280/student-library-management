package com.demo.example.student_library_management.system.requestdto;


import lombok.Data;

@Data
public class StudentRequestDto {

    //dto-data transfer object (it is used to take the request inout fields)

    private String name;
    private String dob;
    private String gender;
    private String email;
    private String department;
    private String sem;

}
