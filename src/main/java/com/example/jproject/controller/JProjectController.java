package com.example.jproject.controller;

import com.example.jproject.model.Student;
import com.example.jproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jproject")
@AllArgsConstructor
public class JProjectController {

    private final StudentService service;

    @GetMapping
    public List<Student> findAllStudent() {
        return service.findAllStudent();
    }
    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student) {
       service.saveStudent(student);
       return "Student save";
    }
    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email)
    {
        return service.findByEmail(email);
    }
    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student)
    {
        return service.updateStudent(student);
    }
        @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email)
    {
        service.deleteStudent(email);
    }
}
