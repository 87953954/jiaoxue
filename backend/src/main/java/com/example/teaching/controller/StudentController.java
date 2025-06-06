package com.example.teaching.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.teaching.entity.Student;
import com.example.teaching.common.Result;
import com.example.teaching.common.ResultUtils;
import com.example.teaching.entity.Student;
import com.example.teaching.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "学生管理")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 获取所有学生信息
     * @return 包含所有学生信息的Result对象
     */
    @Operation(summary = "获取所有学生信息")
    @GetMapping
    public Result<List<Student>> getAllStudents() {
         List<Student> allStudents = studentService.getAllStudents();
        return ResultUtils.success(allStudents);
    }

    /**
     * 根据ID获取学生
     *
     * @param id 学生ID
     * @return 包含学生信息的Result对象
     */
    @Operation(summary = "根据ID获取学生")
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
    @Operation(summary = "添加学生")
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
    @Operation(summary = "修改学生信息")
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
    @Operation(summary = "删除学生")
    @DeleteMapping("/{id}")
    public Result<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResultUtils.success(null);
    }



}