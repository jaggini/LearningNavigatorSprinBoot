package com.example.LearninigNavigatorSpringSecurityAuth.model;

import java.util.List;



import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "students")

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regId;

    @Column(nullable = false)
    private String studentName;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName(String studentName) {
        return studentName;

    }

    @ManyToMany
    @JoinTable(name = "student_exams", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> exam;
    @ManyToMany
    @JoinTable(name = "student_subjects", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> enrolledsubjects;

    public Student(List<Exam> exam, Long regId, String studentName, List<Subject> enrolledsubjects) {
        this.exam = exam;
        this.regId = regId;
        this.studentName = studentName;
        this.enrolledsubjects = enrolledsubjects;
    }

    // public void enrollSubject(Subject s)
    // {
    //     if(!subjects.contains(s))
    //     {
    //         subjects.add(s);
    //         s.getStudents().add(this);
    //     }
    // }
}
