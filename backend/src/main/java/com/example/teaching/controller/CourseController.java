package com.example.teaching.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.example.teaching.entity.Course;
import com.example.teaching.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CourseController 类
 * 该类负责处理与 Course 实体相关的 HTTP 请求。
 * 提供了课程管理相关的 API 接口。
 */
@Tag(name = "课程管理")
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 获取所有课程
     * @return 课程列表
     */
    @Operation(summary = "获取所有课程")
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    /**
     * 创建课程
     * @param course 要创建的课程对象
     * @return ResponseEntity，包含创建成功的课程对象和 HTTP 状态码 CREATED
     */
    @Operation(summary = "创建课程")
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }
    
    /**
     * 根据ID获取课程
     * @param id 课程ID
     * @return ResponseEntity，包含找到的课程对象和 HTTP 状态码 OK，或 HTTP 状态码 NOT_FOUND
     */
    @Operation(summary = "根据ID获取课程")
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * 更新课程信息
     * @param course 要更新的课程对象
     * @return ResponseEntity，包含更新后的课程对象和 HTTP 状态码 OK
     */
    @Operation(summary = "更新课程信息")
    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }
    
    /**
     * 根据ID删除课程
     * @param id 要删除的课程ID
     * @return ResponseEntity，包含 HTTP 状态码 NO_CONTENT
     */
    @Operation(summary = "根据ID删除课程")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * 根据教师ID获取课程
     * @param teacherId 教师ID
     * @return 课程列表
     */
    @Operation(summary = "根据教师ID获取课程")
    @GetMapping("/byTeacher/{teacherId}")
    public List<Course> getCoursesByTeacherId(@PathVariable Long teacherId) {
        return courseService.getCourseByTeacherId(teacherId);
    }
    
    /**
     * 根据学生ID获取课程
     * @param studentId 学生ID
     * @return 课程列表
     */
    @Operation(summary = "根据学生ID获取课程")
    @GetMapping("/byStudent/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable Long studentId) {
        return courseService.getCourseByStudentId(studentId);
    }
}
