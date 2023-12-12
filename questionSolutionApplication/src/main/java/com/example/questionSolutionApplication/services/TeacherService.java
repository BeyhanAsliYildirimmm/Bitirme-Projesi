package com.example.questionSolutionApplication.services;

import com.example.questionSolutionApplication.dto.LoginDto;
import com.example.questionSolutionApplication.entity.Teacher;
import com.example.questionSolutionApplication.entity.UserInformation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    public Teacher saveTeacher(Teacher teacher);
    public ResponseEntity<Object> loginTeacher(LoginDto loginDto);
    public List<Teacher> getAllTeachers();
    public UserInformation TeacherInformation(int id);
    public int deleteTeacherQuestion(String name);
    public Teacher getTeacherById(int id);
    public  void deleteTeacher(int id);
    public Teacher updateTeacher(int id,Teacher teacher);
}
