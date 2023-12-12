package com.example.questionSolutionApplication.controllers;
import com.example.questionSolutionApplication.dto.LoginDto;
import com.example.questionSolutionApplication.entity.QuestionImage;
import com.example.questionSolutionApplication.entity.Teacher;
import com.example.questionSolutionApplication.entity.UserInformation;
import com.example.questionSolutionApplication.repos.QuestionImageRepository;
import com.example.questionSolutionApplication.services.QuestionImageService;
import com.example.questionSolutionApplication.services.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherServiceImpl ;
    @Autowired
    QuestionImageService questionImageService;
    @Autowired
    QuestionImageRepository questionImageRepository;
    @PostMapping("/save")
    public ResponseEntity<Teacher> teacherAdd(@RequestBody Teacher teacher){
        return new ResponseEntity<Teacher>(teacherServiceImpl.saveTeacher(teacher), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public  ResponseEntity<Object> teacherLogin(@RequestBody LoginDto loginDto){
        return teacherServiceImpl.loginTeacher(loginDto);
    }
    @GetMapping("/question-download/{id}")
    public ResponseEntity<List<byte[]>> questionDownload(@PathVariable int id) {
        List<QuestionImage> images = questionImageRepository.findByTeacherId(id);
        List<byte[]> imageBytes = new ArrayList<>();

        for (QuestionImage image : images) {
            byte[] imageData = questionImageService.downloadImage(image.getName());
            imageBytes.add(imageData);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(imageBytes);
    }
    @PostMapping(path = "/question-save")
    public  ResponseEntity<QuestionImage> saveQuestion(@RequestParam("file") MultipartFile file,
                                                       @RequestParam("description") String description,
                                                       @RequestParam("teacherId") int teacherId ) throws IOException {

        return new ResponseEntity<QuestionImage>(questionImageService.uploadTeacherImage(file,description,teacherId),HttpStatus.OK);}
    @GetMapping("/user-information/{id}")
    public ResponseEntity<UserInformation> getTeacherInformationById(@PathVariable int id){
     UserInformation userInformation=  teacherServiceImpl.TeacherInformation(id);
        return ResponseEntity.status(HttpStatus.OK).body(userInformation);}
    @GetMapping("/image/delete/{name}")
    public  ResponseEntity<String> deleteTeacherQuestion(@PathVariable String name){
        int questionImageId= teacherServiceImpl.deleteTeacherQuestion(name);
        questionImageRepository.deleteById(questionImageId);
        return new ResponseEntity<String>("Delete Sucessfully",HttpStatus.OK);}
    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        return new ResponseEntity<List<Teacher>>(teacherServiceImpl.getAllTeachers(),HttpStatus.OK);}
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable int id){
        return new ResponseEntity<Teacher>(teacherServiceImpl.getTeacherById(id),HttpStatus.OK);}
    @GetMapping("/delete/{id}")
    public  ResponseEntity<String> deleteTeacher(@PathVariable int id){
        teacherServiceImpl.deleteTeacher(id);
        return new ResponseEntity<String>("Delete Sucessfully",HttpStatus.OK);}
    @PutMapping("/update/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable int id,@RequestBody Teacher teacher)
    {
        return  new ResponseEntity<Teacher>(teacherServiceImpl.updateTeacher(id,teacher),HttpStatus.OK);
    }
}
