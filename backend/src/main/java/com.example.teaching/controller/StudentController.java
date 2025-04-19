package com.example.teaching.controller;

import com.example.teaching.common.Result;
import com.example.teaching.entity.Student;
import com.example.teaching.common.ResultUtils;
import com.example.teaching.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result<List<Student>> getAllStudents() {
        // 获取所有学生信息
        List<Student> allStudents = studentService.getAllStudents();
        return ResultUtils.success(allStudents);
    }

    /**
     * 根据ID获取学生
     *
     * @param id 学生ID
     * @return 包含学生信息的Result对象
     */
    @GetMapping("/{id}")
    public Result<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }
    /**
     * 添加学生
     *
     * @param student 学生信息
     * @return 包含添加后的学生信息的Result对象
     */
    @PostMapping
    public Result<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResultUtils.success(savedStudent);
    }

    /**
     * 修改学生信息
     *
     * @param student 学生信息
     * @return 包含修改后的学生信息的Result对象
     */
    @PutMapping("/{id}")
    public Result<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        Optional<Student> updatedStudent = studentService.updateStudent(student);
        return updatedStudent.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }
    /**
     * 删除学生
     *
     * @param id 学生ID
     * @return 包含操作结果信息的Result对象
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResultUtils.success(null);
    }



}