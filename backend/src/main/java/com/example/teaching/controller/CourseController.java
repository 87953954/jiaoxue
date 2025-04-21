package com.example.teaching.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.teaching.entity.Course;
import com.example.teaching.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "课程管理")

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @ApiOperation("获取所有课程")
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @ApiOperation("创建课程")
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @ApiOperation("根据ID获取课程")
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @ApiOperation("根据ID删除课程")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }
}
