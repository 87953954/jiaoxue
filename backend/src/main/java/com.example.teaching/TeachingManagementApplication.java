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
            // Clear existing data
            announcementRepository.deleteAll();
            enrollmentRepository.deleteAll();
            courseRepository.deleteAll();
            studentRepository.deleteAll();
            teacherRepository.deleteAll();

            // Add some test teachers
            teacherRepository.save(new Teacher(null, "Teacher 1", "T001"));
            teacherRepository.save(new Teacher(null, "Teacher 2", "T002"));

            // Add some test students
            studentRepository.save(new Student(null, "Student 1", "S001", "Class A"));
            studentRepository.save(new Student(null, "Student 2", "S002", "Class B"));

            // Add some test courses
            courseRepository.save(new Course(null, "Math", 1L));
            courseRepository.save(new Course(null, "English", 2L));

            // Add some test enrollments
            enrollmentRepository.save(new Enrollment(null, 1L, 1L, LocalDateTime.now(), "Room 101"));
            enrollmentRepository.save(new Enrollment(null, 2L, 2L, LocalDateTime.now(), "Room 102"));
            announcementRepository.save(new Announcement(null,"this is a test", LocalDateTime.now(),"Class A"));
        };
    }
}