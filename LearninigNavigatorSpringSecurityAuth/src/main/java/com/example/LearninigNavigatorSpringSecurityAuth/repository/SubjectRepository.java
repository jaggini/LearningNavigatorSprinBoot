package com.example.LearninigNavigatorSpringSecurityAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.LearninigNavigatorSpringSecurityAuth.model.Subject;

@Repository
 public interface SubjectRepository extends JpaRepository<Subject,Long>
{

}
