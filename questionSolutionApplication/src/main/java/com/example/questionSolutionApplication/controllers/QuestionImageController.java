package com.example.questionSolutionApplication.controllers;
import com.example.questionSolutionApplication.entity.Student;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.example.questionSolutionApplication.services.QuestionImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/image")
public class QuestionImageController {
    @Autowired
    private QuestionImageService questionImageService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/upload/student")
    public void uploadStudentImage(@RequestParam("file")MultipartFile file, @RequestParam("description") String description,
                            @RequestParam("studentId") Integer studentId) throws IOException{
        questionImageService.uploadStudentImage(file,description,studentId);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/upload/teacher")
    public void uploadTeacherImage(@RequestParam("file")MultipartFile file, @RequestParam("description") String description,
                            @RequestParam("teacherId") Integer teacherId) throws IOException{
        questionImageService.uploadTeacherImage(file,description,teacherId);
    }

    @GetMapping(path = "/download/{fileName}"
    )
    public ResponseEntity<String> downloadImage(@PathVariable String fileName) {
        byte[] image = questionImageService.downloadImage(fileName);
        String base64Image = Base64.getEncoder().encodeToString(image);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(base64Image);
    }
}
