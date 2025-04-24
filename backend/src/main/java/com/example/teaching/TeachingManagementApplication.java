package com.example.teaching;

import com.example.teaching.entity.*;
import com.example.teaching.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
            Teacher teacher = Teacher.builder()
                    .name("Test Teacher")
                    .teacherNo("T001")
                    .build();
            teacherRepository.save(teacher);

            // Add one test student
            Student student = Student.builder()
                    .name("Test Student")
                    .studentNo("S001")
                    .classNo("Class A")
                    .build();
            studentRepository.save(student);

            // Add one test course
            Course course = Course.builder()
                    .name("Test Course")
                    .description("This is a test course")
                    .classHour(32)
                    .location("Room 101")
                    .students(new ArrayList<>())
                    .build();
            courseRepository.save(course);

            // Add test enrollment
            Enrollment enrollment = Enrollment.builder()
                    .courseId(course.getId())
                    .studentId(student.getId())
                    .enrollmentTime(LocalDateTime.now())
                    .address("Room 101")
                    .build();
            enrollmentRepository.save(enrollment);

            // Add one test announcement
            Announcement announcement = Announcement.builder()
                    .title("Test Announcement")
                    .content("This is a test announcement")
                    .publishTime(LocalDateTime.now())
                    .classNo("Class A")
                    .build();
            announcementRepository.save(announcement);
        };
    }
}