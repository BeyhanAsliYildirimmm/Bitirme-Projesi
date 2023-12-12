package com.example.questionSolutionApplication.services;

import com.example.questionSolutionApplication.dto.LoginDto;
import com.example.questionSolutionApplication.entity.QuestionImage;
import com.example.questionSolutionApplication.entity.Student;
import com.example.questionSolutionApplication.entity.UserInformation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    public Student saveStudent(Student student);
    public ResponseEntity<Object> loginStudent(LoginDto loginDto);
    public UserInformation StudentInformation(int id);
     public int deleteStudentQuestion(String name);
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public  void deleteStudent(int id);
    public Student updateStudent(int id,Student student);
}
