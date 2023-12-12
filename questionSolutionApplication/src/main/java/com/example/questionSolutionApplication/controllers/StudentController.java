package com.example.questionSolutionApplication.controllers;
import com.example.questionSolutionApplication.dto.LoginDto;
import com.example.questionSolutionApplication.entity.QuestionImage;
import com.example.questionSolutionApplication.entity.Student;
import com.example.questionSolutionApplication.entity.UserInformation;
import com.example.questionSolutionApplication.repos.QuestionImageRepository;
import com.example.questionSolutionApplication.repos.StudentRepository;
import com.example.questionSolutionApplication.services.QuestionImageService;
import com.example.questionSolutionApplication.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @Autowired
    QuestionImageService questionImageService;
    @Autowired
    QuestionImageRepository questionImageRepository;
    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/save")
    public ResponseEntity<Student> studentAdd(@RequestBody Student student){
        return new ResponseEntity<Student>(studentServiceImpl.saveStudent(student),HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public  ResponseEntity<Object> StudentLogin(@RequestBody LoginDto loginDto){
        return studentServiceImpl.loginStudent(loginDto);
    }
    @PostMapping(path = "/question-save")
    public  ResponseEntity<QuestionImage> saveQuestion(@RequestParam("file") MultipartFile file,
                                                       @RequestParam("description") String description,
                                                       @RequestParam("studentId") int studentId ) throws IOException {
        return new ResponseEntity<QuestionImage>(questionImageService.uploadStudentImage(file,description,studentId),HttpStatus.OK);}
    @GetMapping("/question-download/{id}")
    public ResponseEntity<List<byte[]>> questionDownload(@PathVariable int id) {
        List<QuestionImage> images = questionImageRepository.findByStudentId(id);
        List<byte[]> imageBytes = new ArrayList<>();
        for (QuestionImage image : images) {
            byte[] imageData = questionImageService.downloadImage(image.getName());
            imageBytes.add(imageData);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(imageBytes);}
    @GetMapping("/user-information/{id}")
    public ResponseEntity<UserInformation> getStudentInformationById(@PathVariable int id){
        UserInformation userInformation=  studentServiceImpl.StudentInformation(id);
      return ResponseEntity.status(HttpStatus.OK).body(userInformation);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<List<Student>>(studentServiceImpl.getAllStudents(),HttpStatus.OK);}
    @GetMapping("/delete/{id}")
    public  ResponseEntity<String> deleteStudent(@PathVariable int id){

        studentServiceImpl.deleteStudent(id);
        return new ResponseEntity<String>("Delete Sucessfully",HttpStatus.OK);
    }
    @GetMapping("/image/delete/{name}")
    public  ResponseEntity<String> deleteStudentQuestion(@PathVariable String name){

       int questionImageId= studentServiceImpl.deleteStudentQuestion(name);
       questionImageRepository.deleteById(questionImageId);
        return new ResponseEntity<String>("Delete Sucessfully",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student student)
    {
        return  new ResponseEntity<Student>(studentServiceImpl.updateStudent(id,student),HttpStatus.OK);
    }
}
