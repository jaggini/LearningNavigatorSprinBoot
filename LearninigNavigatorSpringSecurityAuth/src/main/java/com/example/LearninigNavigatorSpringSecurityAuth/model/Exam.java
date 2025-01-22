package com.example.LearninigNavigatorSpringSecurityAuth.model;

import java.util.List;

import javax.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

///import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "exams")

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subId;

    @OneToOne
    @JoinColumn(name = "subject_id")

    private Subject subject;

    @ManyToMany(mappedBy = "enrolledSubjects")
    private List<Student> student;

}
