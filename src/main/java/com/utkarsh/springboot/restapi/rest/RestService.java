package com.utkarsh.springboot.restapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class RestService {

    public StudentDAO studentDAO;

    @Autowired
    public RestService(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    @GetMapping("/rest")
    public List<Student> contact(){
        List<Student> students = this.studentDAO.getStudentList();
        System.out.println(students);
        return students;
    }


    @GetMapping("/rest/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(this.studentDAO.getStudentById(studentId) == null){
            throw new StudentException("Student with id: " + studentId + " does not exist!");
        }
        return this.studentDAO.getStudentById(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentException studentException){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentException.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }
}
