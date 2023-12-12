package com.example.questionSolutionApplication.repos;
import com.example.questionSolutionApplication.entity.QuestionImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionImageRepository extends JpaRepository<QuestionImage,Integer> {
    Optional<QuestionImage> findByname(String fileName);
    List<QuestionImage> findByStudentId(int studentId);
    List<QuestionImage> findByTeacherId(int teacherId);

    @Query(value = "SELECT us.id from question_image us where us.name=:n ", nativeQuery = true)
    public int getQuestionId(@Param("n") String name );
}
