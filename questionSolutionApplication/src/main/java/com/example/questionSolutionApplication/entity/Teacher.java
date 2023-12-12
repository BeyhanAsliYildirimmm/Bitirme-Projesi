package com.example.questionSolutionApplication.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Entity
@Table(name = "teacher")
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fistName")
    private String fistName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "brans")
    private String brans;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message ="{hoaxify.constraints.password.Pattern.message}" )
    @Column(name = "password")
    private  String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_information_id",nullable = true)
    @JsonIgnore
    private UserInformation userInformation;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private Set<QuestionImage> questionImages;




}
