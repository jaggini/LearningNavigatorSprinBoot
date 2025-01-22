
package com.example.LearninigNavigatorSpringSecurityAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LearninigNavigatorSpringSecurityAuth.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long>
{
  
}