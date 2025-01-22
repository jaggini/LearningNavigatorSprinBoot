
package com.example.LearninigNavigatorSpringSecurityAuth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.LearninigNavigatorSpringSecurityAuth.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>
{

}