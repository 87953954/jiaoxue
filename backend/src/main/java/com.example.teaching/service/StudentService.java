package com.example.teaching.service;

        import com.example.teaching.entity.Student;
        import com.example.teaching.repository.StudentRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

        @Service
        public class StudentService {

            @Autowired
            private StudentRepository studentRepository;

            public List<Student> getAllStudents() {
                return studentRepository.findAll();
            }
        }