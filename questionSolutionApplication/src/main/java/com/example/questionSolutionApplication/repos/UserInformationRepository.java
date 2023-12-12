package com.example.questionSolutionApplication.repos;
import com.example.questionSolutionApplication.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation,Integer> {
public UserInformation findByid(int id);
}
