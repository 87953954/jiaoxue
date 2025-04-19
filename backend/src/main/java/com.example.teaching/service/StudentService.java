package com.example.teaching.service;

        import com.example.teaching.entity.Student;
        import com.example.teaching.repository.StudentRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

        @Service
        public class StudentService {

            @Autowired
            private StudentRepository studentRepository;
        
            public List<Student> getAllStudents() {
                return studentRepository.findAll();
            }

            public Optional<Student> getStudentById(Long id) {
                return studentRepository.findById(id);
            }
        
            public Student addStudent(Student student) {
                return studentRepository.save(student);
            }
        
            public Optional<Student> updateStudent(Student student) {
                Optional<Student> existingStudent = studentRepository.findById(student.getId());
                if (existingStudent.isPresent()) {
                    return Optional.of(studentRepository.save(student));
                }
                return Optional.empty();
            }
        
            public void deleteStudent(Long id) {
                studentRepository.deleteById(id);
            }
        }
