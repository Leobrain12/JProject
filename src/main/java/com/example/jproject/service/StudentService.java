package com.example.jproject.service;

import com.example.jproject.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
     List<Student> findAllStudent();
     Student saveStudent(Student student);
     Student findByEmail(String email);
     Student updateStudent(Student student);
     void deleteStudent(String email);
}
