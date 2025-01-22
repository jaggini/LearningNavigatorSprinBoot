package com.example.LearninigNavigatorSpringSecurityAuth.serviece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.LearninigNavigatorSpringSecurityAuth.repository.StudentRepository;
import com.example.LearninigNavigatorSpringSecurityAuth.model.Student;
import com.example.LearninigNavigatorSpringSecurityAuth.repository.ExamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;



    @Autowired
    private ExamRepository examRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    
    public List<Student> getAllStudents()
    {
          return studentRepository.findAll();

    }

    public Student createStudent(Student s)
    {
        return studentRepository.save(s);
    }




    public Student getStudent(Long id)
    {
      return studentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Student not found"));
      
    }


  public Student updateStudent(Long id)
  {
    Student s=studentRepository.findById(id).orElseThrow(()-> new NoSuchElementException("student Not found"));
    s.setStudentName(s.getStudentName());
    s.setExam(s.getExam());
    s.setSubjects(s.getSubjects());
    
    return studentRepository.save(s);


  }

  public void deleteStudent(Student s)
  {
      studentRepository.delete(s);
  }




    

}
