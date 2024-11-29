package com.demo.example.student_library_management.system.service;


import com.demo.example.student_library_management.system.converters.StudentConvertor;
import com.demo.example.student_library_management.system.enums.CardStatus;
import com.demo.example.student_library_management.system.model.Card;
import com.demo.example.student_library_management.system.model.Student;
import com.demo.example.student_library_management.system.repository.StudentRepository;
import com.demo.example.student_library_management.system.requestdto.StudentRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public String addStudent(StudentRequestDto studentRequestDto) {
        logger.info("addStudent");
       Student student= StudentConvertor.convertStudentRequestdtoIntoStudent(studentRequestDto);
       if(student==null){
           logger.error("student is null");
           throw new RuntimeException();
       }


       // whenever  the student gets added card also issued the student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);

        student.setCard(card);

       studentRepository.save(student);
       logger.info("student saved");
       return "Student saved successfully";
    }

    public Student getStudentById(int studentId) {
        logger.info("getStudentById");
        Optional<Student> studentOptinal= studentRepository.findById(studentId);
        if(!studentOptinal.isPresent()){
            logger.error("student not found");
            throw new RuntimeException();
        }
        Student student=studentOptinal.get();
        logger.info("student found");
        return student;
    }

    public List<Student> getAllStudents() {
      List<Student> studentList= studentRepository.findAll();
      return studentList;
    }

    /*

    pagination-feteching the data or records in the form of pages
    pagenumber-the number of pages we want to see(page number starts from 0,1,2,3...)
    pageSize-total number of records or data in each page(it is fixed for each page)

    databsae total records/data-28, page size-5
    0th page -> 1-5
    1 st page->6-10
    2 nd page->11-15
    3 rd page-> 16-20
    4 th page->21-25
    5 th page->26-28

    database total records -11 , pagesize-2
    0th page->1-2
    1st page->3-4
    2nd page->5-6
    3rd page->7-8
    4th page->9-10
    5th page->11

    sorting -arrange the data or records in ascending or descending order
     */

    public List<Student> getStudentsBasedOnPage(int page,int size,String sortInput) {

        //only pagination-page<Student> studentPage=studentRepositry.findAll(PageRequest.of(pageNo,pageSize));
        //pagination and sorting together
        Page<Student> studentPage=studentRepository.findAll(PageRequest.of(page,size, Sort.by(sortInput).ascending()));
      // we cannot send page as ouptu so we need to convert is to list
        List<Student> studentList= studentPage.getContent();
        return studentList;

    }

    public long countStudents() {
       long count= studentRepository.count();
       return count;
    }

    public String deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
        return "student deleted";
    }

    public String updateStudent(int studentId,StudentRequestDto newStudentRequestDto) {
        // first take students id and find student details
        // if student present update it
        // else no need
        Student student= getStudentById(studentId);
        if(student!=null){
           student.setName(newStudentRequestDto.getName());
           student.setGender(newStudentRequestDto.getGender());
           student.setSem(newStudentRequestDto.getSem());
           student.setDob(newStudentRequestDto.getDob());
           student.setEmail(newStudentRequestDto.getEmail());
           student.setDepartment(newStudentRequestDto.getDepartment());
           studentRepository.save(student);
           return "Student updated successfully";
        }else{
            return "cannot find student to updated";
        }
    }

    public List<Student> getStudentByDepartment(String department) {
        List<Student> studentList= studentRepository.findByDepartment(department);
        return studentList;
    }
    public List<Student> getStudentBySem(String sem) {
        List<Student> studentList= studentRepository.getStudentBySem(sem);
        return studentList;
    }
}
