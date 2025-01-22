package com.example.LearninigNavigatorSpringSecurityAuth.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="students")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regId;
    @Column(nullable=false)
    private String studentName;

    public void setStudentName(String studentName)
    {
        this.studentName=studentName;
    }

    public String getStudentName(String studentName)
    {
        return studentName;
        
    }


    @ManyToMany
    @JoinTable(name="student_exams",joinColumns=@JoinColumn(name="student_id"),
    inverseJoinColumns=@JoinColumn(name="exam_id"))
    private List<Exam> exam; 
    @ManyToMany
    @JoinTable(name="student_subjects",joinColumns=@JoinColumn(name="student_id"),
    inverseJoinColumns=@JoinColumn(name="subject_id"))
     private List<Subject> subjects;

   
    public Student(List<Exam> exam, Long regId, String studentName, List<Subject> subjects) {
        this.exam = exam;
        this.regId = regId;
        this.studentName = studentName;
        this.subjects = subjects;
    }


}
 
