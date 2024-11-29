package com.demo.example.student_library_management.system.converters;

import com.demo.example.student_library_management.system.model.Student;
import com.demo.example.student_library_management.system.requestdto.StudentRequestDto;

public class StudentConvertor {


    //converts - used to convert the coming input request dto coming into the model or entity class which directly represents databse

    //converts studentRequestDto  into student class

    public static Student convertStudentRequestdtoIntoStudent(StudentRequestDto studentRequestDto) {
//        Student student = new Student();
//        student.setName(studentRequestDto.getName());
//        student.setEmail(studentRequestDto.getEmail());
//        student.setDob(studentRequestDto.getDob());
//        student.setGender(studentRequestDto.getGender());
//        student.setDepartment(studentRequestDto.getDepartment());
//        student.setSem(studentRequestDto.getSem());

        Student student=  Student.builder()
                .name(studentRequestDto.getName())
                .email(studentRequestDto.getEmail())
                .dob(studentRequestDto.getDob())
                .department(studentRequestDto.getDepartment())
                .gender(studentRequestDto.getGender())
                .sem(studentRequestDto.getSem()).build();

      return student;
    }
}
