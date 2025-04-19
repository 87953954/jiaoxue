package com.example.teaching;

import com.example.teaching.entity.Announcement;
import com.example.teaching.entity.Course;
import com.example.teaching.entity.Enrollment;
import com.example.teaching.entity.Student;
import com.example.teaching.entity.Teacher;
import com.example.teaching.repository.AnnouncementRepository;
import com.example.teaching.repository.CourseRepository;
import com.example.teaching.repository.EnrollmentRepository;
import com.example.teaching.repository.StudentRepository;
import com.example.teaching.repository.TeacherRepository;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeachingManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachingManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(TeacherRepository teacherRepository,
        StudentRepository studentRepository,
        CourseRepository courseRepository,
        EnrollmentRepository enrollmentRepository,
        AnnouncementRepository announcementRepository) {
        return args -> {

            // Add one test teacher
            teacherRepository.save(new Teacher(null, "Test Teacher", "T001"));

            // Add one test student
            studentRepository.save(new Student(null, "Test Student", "S001", "Class A"));

            // Add one test course
            courseRepository.save(new Course(null, "Test Course", 1L));

            // Add some test enrollments
            enrollmentRepository.save(new Enrollment(null, 1L, 1L, LocalDateTime.now(), "Room 101"));
            enrollmentRepository.save(new Enrollment(null, 2L, 2L, LocalDateTime.now(), "Room 102"));
            announcementRepository.save(new Announcement(null,"this is a test", LocalDateTime.now(),"Class A"));
        };
    }
}