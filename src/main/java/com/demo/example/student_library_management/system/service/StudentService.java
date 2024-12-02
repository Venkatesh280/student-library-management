package com.demo.example.student_library_management.system.service;


import com.demo.example.student_library_management.system.converters.StudentConvertor;
import com.demo.example.student_library_management.system.enums.CardStatus;
import com.demo.example.student_library_management.system.model.Card;
import com.demo.example.student_library_management.system.model.Student;
import com.demo.example.student_library_management.system.repository.StudentRepository;
import com.demo.example.student_library_management.system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto) {
       Student student= StudentConvertor.convertStudentRequestdtoIntoStudent(studentRequestDto);

       // whenever  the student gets added card also issued the student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);

        student.setCard(card);

       studentRepository.save(student);
       return "Student saved successfully";
    }
}
