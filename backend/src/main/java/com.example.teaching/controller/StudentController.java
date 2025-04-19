package com.example.teaching.controller;

import com.example.teaching.entity.Student;
import com.example.teaching.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student) {return studentService.addStudent(student);}
    @PutMapping("/{id}")
    public Optional<Student> updateStudent(@RequestBody Student student) {return studentService.updateStudent(student);}
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {studentService.deleteStudent(id);}

    }
}