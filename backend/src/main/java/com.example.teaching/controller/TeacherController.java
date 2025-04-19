package com.example.teaching.controller;

import com.example.teaching.common.Result;
import com.example.teaching.common.ResultUtils;
import com.example.teaching.entity.Teacher;
import com.example.teaching.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import jakarta.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public Result<List<Teacher>> getAllTeachers() {
        return ResultUtils.success(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public Result<Teacher> getTeacherById(@PathVariable Long id) {
        return ResultUtils.success(teacherService.getTeacherById(id).orElse(null));
    }

    @PostMapping
    public Result<Teacher> addTeacher(@RequestBody Teacher teacher) {
        return ResultUtils.success(teacherService.addTeacher(teacher));
    }

    @PutMapping("/{id}")
    public Result<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return ResultUtils.success(teacherService.updateTeacher(teacher).orElse(null));
    }

    @DeleteMapping("/{id}")
    public Result<Object> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResultUtils.success(null);
    }


}