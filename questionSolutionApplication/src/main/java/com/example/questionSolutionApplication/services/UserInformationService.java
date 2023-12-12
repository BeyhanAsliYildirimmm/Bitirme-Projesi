package com.example.questionSolutionApplication.services;


import com.example.questionSolutionApplication.entity.UserInformation;


public interface UserInformationService {

    public UserInformation saveUserInformation(UserInformation userInformation);
    public UserInformation getUserById(int id);
}

