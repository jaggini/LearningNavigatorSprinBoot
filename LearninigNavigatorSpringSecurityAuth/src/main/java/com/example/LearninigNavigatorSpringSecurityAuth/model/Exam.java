package com.example.LearninigNavigatorSpringSecurityAuth.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subId;
    
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subject> subjects;

    @ManyToMany(mappedBy = "enrolledSubjects")
    private List<Student> student;

}
