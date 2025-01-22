package com.example.LearninigNavigatorSpringSecurityAuth.serviece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.LearninigNavigatorSpringSecurityAuth.model.Exam;
import com.example.LearninigNavigatorSpringSecurityAuth.model.Student;
import com.example.LearninigNavigatorSpringSecurityAuth.repository.ExamRepository;
import com.example.LearninigNavigatorSpringSecurityAuth.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    public void register(long studentiId, Long examId) {
        Student s = studentRepository.findById(studentiId).orElseThrow(() -> new EntityNotFoundException("Student not found"));

        Exam e = examRepository.findById(examId).orElseThrow(() -> new EntityNotFoundException("Exam not Found"));

        if (!s.getEnrolledsubjects().contains(e.getSubject())) {
            throw new IllegalStateException("Student must be enrollled in the subject to register for the exam");

        }
        s.getExam().add(e);

        studentRepository.save(s);
    }


    public String getNumberFact(int number) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://numbersapi.com/" + number;
        return restTemplate.getForObject(url, String.class);

    }

}
