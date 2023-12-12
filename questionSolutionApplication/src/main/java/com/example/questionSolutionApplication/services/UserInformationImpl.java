package com.example.questionSolutionApplication.services;
import com.example.questionSolutionApplication.entity.UserInformation;
import com.example.questionSolutionApplication.repos.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInformationImpl implements UserInformationService {
    @Autowired
    private UserInformationRepository userRepo;
    @Override
    public UserInformation saveUserInformation(UserInformation userInformation) {
        return userRepo.save(userInformation);
    }
    @Override
    public  UserInformation getUserById(int id){
        return null;

    }
}
