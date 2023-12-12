package com.example.questionSolutionApplication.services;
import com.example.questionSolutionApplication.DBUtil;
import com.example.questionSolutionApplication.dto.LoginDto;
import com.example.questionSolutionApplication.entity.QuestionImage;
import com.example.questionSolutionApplication.entity.Student;
import com.example.questionSolutionApplication.entity.UserInformation;
import com.example.questionSolutionApplication.error.ApiError;
import com.example.questionSolutionApplication.repos.QuestionImageRepository;
import com.example.questionSolutionApplication.repos.StudentRepository;
import com.example.questionSolutionApplication.repos.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {
    public int studentId;
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private UserInformationRepository userInformationRepos;
    @Autowired
    private QuestionImageRepository questionImageRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
   @Override
    public ResponseEntity<Object> loginStudent(LoginDto loginDto) {
        String email=loginDto.getEmail();
       Student inDB= studentRepo.findByemail(email);
       studentId=inDB.getId();
       if(inDB !=null){
           String studentValue= studentRepo.getUserLoginControl(studentId,loginDto.getPassword());
           if(studentValue != null) {
               return ResponseEntity.status(HttpStatus.OK).body(inDB);}
           else{
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fail");}}
       else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fail");}}
    @Override
    public UserInformation StudentInformation(int id) {
        Student student=studentRepo.findById(id);
        int informationId= student.getUserInformation().getId();
        UserInformation userInformation = userInformationRepos.findByid(informationId);
        return userInformation;}
    @Override
    public void deleteStudent(int id) {
     Student student=studentRepo.findById(id);
     if(student!=null)
         studentRepo.delete(student);}
    @Override
    public  int deleteStudentQuestion(String name){
       int questionImageId = questionImageRepository.getQuestionId(name);
        return questionImageId;}
    @Override
    public Student updateStudent(int id, Student student) {
        return null;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    @Override
    public Student getStudentById(int id) {return studentRepo.findById(id);}
}
