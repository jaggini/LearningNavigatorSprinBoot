package com.example.LearninigNavigatorSpringSecurityAuth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.LearninigNavigatorSpringSecurityAuth.serviece.ExamService;

@RestController
@RequestMapping("/exams")
public class EsterController {

    @Autowired
    private ExamService examservice;

    @PostMapping("/{examId}")
    public ResponseEntity<String> registerForTheExam(@PathVariable Long examId, @RequestParam Long studentId) {
        examservice.register(studentId, examId);
        return ResponseEntity.ok("Student registered for exam successfully");
    }

    @GetMapping("/hidden-feature/{number}")
    public ResponseEntity<String> getNumberFact(@PathVariable int number) {
        //String f = "Random fact about the number" + number + ":its cool";
        return ResponseEntity.ok(examservice.getNumberFact(number));
    }
}
