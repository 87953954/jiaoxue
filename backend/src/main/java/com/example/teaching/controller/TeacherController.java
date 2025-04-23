package com.example.teaching.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.teaching.common.Result;
import com.example.teaching.common.ResultUtils;
import com.example.teaching.entity.Teacher;
import com.example.teaching.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Tag(name = "教师管理")
 * 该类负责处理与 Teacher 实体相关的 HTTP 请求。
 * 提供了教师管理相关的 API 接口。
 */
@Tag(name = "教师管理")
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    
    /**
     * 获取所有教师信息
     * @return 教师列表
     */
    @Operation(summary = "获取所有教师")
    @GetMapping
    public Result<List<Teacher>> getAllTeachers() {
        return ResultUtils.success(teacherService.getAllTeachers());
    }
    
    /**
     * 根据ID获取教师信息
     * @param id 教师ID
     * @return 找到的教师信息
     */
    @Operation(summary = "根据ID获取教师")
    @GetMapping("/{id}")
    public Result<Teacher> getTeacherById(@PathVariable Long id) {
        return ResultUtils.success(teacherService.getTeacherById(id).orElse(null));
    }
    
    /**
     * 添加教师信息
     * @param teacher 要添加的教师对象
     * @return 添加后的教师对象
     */
    @Operation(summary = "添加教师")
    @PostMapping
    public Result<Teacher> addTeacher(@RequestBody Teacher teacher) {
        return ResultUtils.success(teacherService.addTeacher(teacher));
    }
    
    /**
     * 更新教师信息
     * @param id 教师ID
     * @param teacher 要更新的教师对象
     * @return 更新后的教师对象
     */
    @Operation(summary = "更新教师")
    @PutMapping("/{id}")
    public Result<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return ResultUtils.success(teacherService.updateTeacher(teacher).orElse(null));
    }
    
    /**
     * 删除教师信息
     * @param id 要删除的教师ID
     * @return 删除结果
     */
    @Operation(summary = "删除教师")
    @DeleteMapping("/{id}")
    public Result<Object> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResultUtils.success(null);
    }


}