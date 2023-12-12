package com.example.questionSolutionApplication.repos;

import com.example.questionSolutionApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByemail(String email);
    Student findById(int id);
    @Query(value = "SELECT us.email from student us where us.id=:i and us.password=:p", nativeQuery = true)
    public String getUserLoginControl(@Param("i") int userId, @Param("p") String userPassword);
}
