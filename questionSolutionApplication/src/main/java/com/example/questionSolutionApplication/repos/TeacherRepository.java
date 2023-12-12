package com.example.questionSolutionApplication.repos;

import com.example.questionSolutionApplication.entity.Student;
import com.example.questionSolutionApplication.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findByemail(String email);
    Teacher findById(int id);
    @Query(value = "SELECT us.email from teacher us where us.id=:i and us.password=:p", nativeQuery = true)
    public String getUserLoginControl(@Param("i") int userId, @Param("p") String userPassword);


}
