package com.example.teaching.service;

import com.example.teaching.entity.Course;
import com.example.teaching.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(Course course) {
        Optional<Course> existingCourse = courseRepository.findById(course.getId());
        if (existingCourse.isPresent()){
            return Optional.of(courseRepository.save(course));
        }
        return Optional.empty();
    }

    public void deleteCourse(Long id) {courseRepository.deleteById(id);}

}