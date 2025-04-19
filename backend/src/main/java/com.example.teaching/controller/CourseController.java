package com.example.teaching.controller;

import com.example.teaching.common.Result;
import com.example.teaching.common.ResultUtils;
import com.example.teaching.entity.Course;
import com.example.teaching.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/courses")
public class CourseController {

  @Autowired
  private CourseService courseService;

  /**
   * 获取所有课程
   *
   * @return 课程列表
   */
  @GetMapping
  public Result<List<Course>> getAllCourses() {
    List<Course> allCourses = courseService.getAllCourses();
    return ResultUtils.success(allCourses);
  }

  /**
   * 通过id获取课程
   * @param id 课程id
   * @return 课程信息
   */
  @GetMapping("/{id}")
  public Result<Course> getCourseById(@PathVariable Long id) {
    Optional<Course> course = courseService.getCourseById(id);
    return course.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
  }

  /**
   * 添加课程
   * @param course 课程信息
   * @return 添加后的课程信息
   */
  @PostMapping
  public Result<Course> addCourse(@RequestBody Course course) {
      Course savedCourse = courseService.addCourse(course);
      return ResultUtils.success(savedCourse);
  }
  @PutMapping("/{id}")
  public Result<Course> updateCourse(@PathVariable Long id,@RequestBody Course course){
      course.setId(id);
      Optional<Course> updatedCourse = courseService.updateCourse(course);
      return updatedCourse.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
  }
  @DeleteMapping("/{id}")
  public Result<String> deleteCourse(@PathVariable Long id){
      courseService.deleteCourse(id);
      return ResultUtils.success(null);
  }

}