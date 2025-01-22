package com.example.LearninigNavigatorSpringSecurityAuth.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

@Table(name="subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;
    @Column(nullable=false)
    private String subject;
    
    @ManyToMany(mappedBy="enrolledSubjects")
     private List<Student> students;

   @OneToMany(mappedBy="subject",cascade=CascadeType.ALL,orphanRemoval=true)
   private List<Exam> exams;
   
}
