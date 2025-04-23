package com.example.teaching.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.teaching.common.Result;
import com.example.teaching.common.ResultUtils;
import com.example.teaching.entity.Enrollment;
import com.example.teaching.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 选课信息管理控制器
 */
@Tag(name = "选课信息管理")
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    /**
     * 查询所有选课信息
     * @return 包含所有选课信息的 Result 对象
     */
    @Operation(summary = "查询所有选课信息")
    @GetMapping
    public Result<List<Enrollment>> getAllEnrollments() {
        List<Enrollment> allEnrollments = enrollmentService.getAllEnrollments();
        return ResultUtils.success(allEnrollments);
    }

    /**
     * 根据 ID 查询选课信息
     * @param id 选课信息的 ID
     * @return 包含选课信息的 Result 对象，如果找不到则返回 null
     */
    @Operation(summary = "根据 ID 查询选课信息")
    @GetMapping("/{id}")
    public Result<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollment> enrollment = enrollmentService.getEnrollmentById(id);
        return enrollment.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }

    /**
     * 添加选课信息
     * @param enrollment 要添加的选课信息
     * @return 包含添加后的选课信息的 Result 对象
     */
    @Operation(summary = "添加选课信息")
    @PostMapping
    public Result<Enrollment> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment savedEnrollment = enrollmentService.addEnrollment(enrollment);
        return ResultUtils.success(savedEnrollment);
    }

    /**
     * 根据 ID 删除选课信息
     * @param id 要删除的选课信息的 ID
     * @return 包含操作结果的 Result 对象
     */
    @Operation(summary = "根据 ID 删除选课信息")
    @DeleteMapping("/{id}")
    public Result<String> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResultUtils.success(null);
    }

    /**
     * 更新选课信息
     * @param id 要更新的选课信息的 ID
     * @param enrollment 包含更新信息的选课对象
     * @return 包含更新后的选课信息的 Result 对象，如果找不到则返回 null
     */
    @Operation(summary = "更新选课信息")
    @PutMapping("/{id}")
    public Result<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        enrollment.setId(id);
        Optional<Enrollment> updatedEnrollment = enrollmentService.updateEnrollment(enrollment);
        return updatedEnrollment.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }
}
