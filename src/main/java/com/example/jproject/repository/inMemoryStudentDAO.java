package com.example.jproject.repository;

import com.example.jproject.model.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Repository
public class inMemoryStudentDAO {
    private final List<Student> STUDENT = new ArrayList<>();

    public List<Student> findAllStudent() {
        return STUDENT;
    }

    public Student saveStudent(Student student) {
        STUDENT.add(student);
        return student;
    }

    public Student findByEmail(String email) {
        return STUDENT.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0,STUDENT.size())
                .filter(index -> STUDENT.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if(studentIndex > -1)
        {
            STUDENT.set(studentIndex,student);
            return student;
        }
        return null;
    }

    public void deleteStudent(String email) {
        var student = findByEmail(email);
        if(student != null)
        {
            STUDENT.remove(student);
        }
    }
}
