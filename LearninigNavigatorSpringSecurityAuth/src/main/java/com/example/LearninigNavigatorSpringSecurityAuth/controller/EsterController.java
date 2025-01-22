package com.example.LearninigNavigatorSpringSecurityAuth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/hidden-feature")
public class EsterController {

    public ResponseEntity<String> getNumberFact(@PathVariable int number) {
        String f = "Random fact about the number" + number + ":its cool";
        return ResponseEntity.ok(f);
    }
}
