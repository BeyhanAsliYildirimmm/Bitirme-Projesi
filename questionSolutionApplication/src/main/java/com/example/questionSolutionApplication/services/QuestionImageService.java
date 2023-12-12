package com.example.questionSolutionApplication.services;

import com.example.questionSolutionApplication.ImageUtil;
import com.example.questionSolutionApplication.entity.QuestionImage;
import com.example.questionSolutionApplication.entity.Student;
import com.example.questionSolutionApplication.entity.Teacher;
import com.example.questionSolutionApplication.repos.QuestionImageRepository;
import com.example.questionSolutionApplication.repos.StudentRepository;
import com.example.questionSolutionApplication.repos.TeacherRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionImageService {
    @Autowired
    private QuestionImageRepository imageRepo;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    public QuestionImage uploadStudentImage(MultipartFile file, String description, Integer studentId) throws IOException {
        QuestionImage pImage = new QuestionImage();
        Student student = studentRepository.findById(studentId).orElse(null);
        pImage.setStudentId(studentId);
        pImage.setStudent(student);
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
        return imageRepo.save(pImage);}
    public QuestionImage uploadTeacherImage(MultipartFile file, String description, Integer teacherId) throws IOException {
        QuestionImage pImage = new QuestionImage();
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        pImage.setTeacherId(teacherId);
        pImage.setTeacher(teacher);
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
        return imageRepo.save(pImage);}
    public byte[] downloadImage(String fileName) {
        Optional<QuestionImage> imageDataOptional = imageRepo.findByname(fileName);
        if (imageDataOptional.isPresent()) {
            return ImageUtil.decompressImage(imageDataOptional.get().getImageData());
        } else {return null;}}}
