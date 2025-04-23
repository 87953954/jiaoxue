package com.example.teaching.service;

import com.example.teaching.entity.Course;
import com.example.teaching.repository.CourseRepository;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * CourseService 类
 * 该类提供了对 Course 实体进行业务操作的服务方法。
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    /**
     * 获取所有课程
     * @return 课程列表
     */
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    /**
     * 创建课程
     * @param course 要创建的课程对象
     * @return 创建成功的课程对象
     */
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    /**
     * 根据ID获取课程
     * @param id 课程ID
     * @return 找到的课程对象，如果不存在则返回null
     */
    public Course getCourseById(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.orElse(null);
    }

    /**
     * 更新课程信息
     * @param course 要更新的课程对象
     * @return 更新后的课程对象
     */
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    /**
     * 根据ID删除课程
     * @param id 要删除的课程ID
     */
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    /**
     * 根据教师ID获取课程列表
     * @param teacherId 教师ID
     * @return 该教师教授的课程列表
     */
    public List<Course> getCourseByTeacherId(Long teacherId) {
        List<Course> courses = courseRepository.findAll();
        List<Course> teacherCourses = courses.stream().filter(course -> course.getTeacherId().equals(teacherId)).collect(Collectors.toList());
        if (teacherCourses.isEmpty()) {
            return new ArrayList<>();
        }
        return teacherCourses;
    }

    /**
     * 根据学生ID获取课程列表
     * @param studentId 学生ID
     * @return 该学生选修的课程列表
     */
    public List<Course> getCourseByStudentId(Long studentId) {
        List<Course> courses = courseRepository.findAll();
        List<Course> studentCourses = courses.stream().filter(course -> course.getStudentIds().contains(studentId)).collect(Collectors.toList());
        if (studentCourses.isEmpty()) {
          return new ArrayList<>();
        }
        return studentCourses;
    }

}