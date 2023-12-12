package com.example.questionSolutionApplication.controllers;

import com.example.questionSolutionApplication.entity.Student;
import com.example.questionSolutionApplication.entity.UserInformation;
import com.example.questionSolutionApplication.services.StudentServiceImpl;
import com.example.questionSolutionApplication.services.UserInformationImpl;
import com.example.questionSolutionApplication.services.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user-information")
public class UserInformationController {
    @Autowired
    UserInformationImpl userInformationImpl;
    @PostMapping("/save")
    public ResponseEntity<UserInformation> userInformationAdd(@RequestBody UserInformation userInformation){
        return new ResponseEntity<UserInformation>(userInformationImpl.saveUserInformation(userInformation), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<UserInformation> getUserInformation(@PathVariable("id") int id){

        return new ResponseEntity<UserInformation>(userInformationImpl.getUserById(id),HttpStatus.OK);
    }
}
