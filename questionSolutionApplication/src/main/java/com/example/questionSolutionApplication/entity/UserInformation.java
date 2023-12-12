package com.example.questionSolutionApplication.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "user-information")
@Data
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fistName")
    private String fistName;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "linkedIn")
    private  String linkedIn;
    @Column(name = "instagram")
    private  String instagram;
    @OneToOne(mappedBy = "userInformation", optional = false)
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "userInformation", optional = false)
    @JsonBackReference
    private Teacher teacher;

}
