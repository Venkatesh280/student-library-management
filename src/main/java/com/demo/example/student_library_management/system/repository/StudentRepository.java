package com.demo.example.student_library_management.system.repository;

import com.demo.example.student_library_management.system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //customized queries-our own user defined queries

    //1.writing own methods with fields or attributes with JPA support
    public Student findByEmail(String email);

    public List<Student> findBySem(String sem);

    public List<Student> findByDepartment(String department);

    public List<Student> findBySemAndDepartment(String sem, String department);

    public List<Student> findByDepartmentOrSem(String department, String sem);

    //2.writing our own complete query without jpa support(to write query)

    @Query(nativeQuery= true,value="SELECT * FROM student WHERE sem= :inputSem;")
    public List<Student> getStudentBySem(String inputSem);

}
