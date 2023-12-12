package com.example.questionSolutionApplication.services;
import com.example.questionSolutionApplication.dto.LoginDto;
import com.example.questionSolutionApplication.entity.Teacher;
import com.example.questionSolutionApplication.entity.UserInformation;
import com.example.questionSolutionApplication.repos.QuestionImageRepository;
import com.example.questionSolutionApplication.repos.TeacherRepository;
import com.example.questionSolutionApplication.repos.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {
   @Autowired
    private TeacherRepository teacherRepo;
    public int teacherId;
    @Autowired
    private UserInformationRepository userInformationRepos;
    @Autowired
    private QuestionImageRepository questionImageRepository;
    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }
    @Override
    public ResponseEntity<Object> loginTeacher(LoginDto loginDto) {
        String email=loginDto.getEmail();
        Teacher inDB= teacherRepo.findByemail(email);
        teacherId=inDB.getId();
        if(inDB !=null){
            String studentValue= teacherRepo.getUserLoginControl(teacherId,loginDto.getPassword());
            if(studentValue != null) {
                return ResponseEntity.status(HttpStatus.OK).body(inDB);}
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fail");}}
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fail");}}
    @Override
    public UserInformation TeacherInformation(int id) {
     Teacher teacher= teacherRepo.findById(id);
     int informationId= teacher.getUserInformation().getId();
      UserInformation userInformation = userInformationRepos.findByid(informationId);
        return userInformation;}
    @Override
    public int deleteTeacherQuestion(String name) {

        int questionImageId = questionImageRepository.getQuestionId(name);
        return questionImageId;}
    @Override
    public void deleteTeacher(int id) {
        Teacher teacher=teacherRepo.findById(id);
        if(teacher!=null)
            teacherRepo.delete(teacher);}
    @Override
    public Teacher updateTeacher(int id, Teacher teacher) {
        return null;
    }
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }
    @Override
    public Teacher getTeacherById(int id) {
        return teacherRepo.findById(id);
    }

}