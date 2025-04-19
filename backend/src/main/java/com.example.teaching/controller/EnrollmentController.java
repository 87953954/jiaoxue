package com.example.teaching.controller;

import com.example.teaching.common.Result;
import com.example.teaching.common.ResultUtils;
import com.example.teaching.entity.Enrollment;
import com.example.teaching.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName EnrollmentController
 * @Description
 */
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private  EnrollmentService enrollmentService;
    /**
     * @return {@link Result<List<Enrollment>>}
     * @Description 查询所有选课信息
     */
    @GetMapping
    public Result<List<Enrollment>> getAllEnrollments() {
        List<Enrollment> allEnrollments = enrollmentService.getAllEnrollment();
        return ResultUtils.success(allEnrollments);
    }
    /**
     * @param id
     * @return {@link Result<Enrollment>}
     * @Description 根据id查询选课信息
     */
    @GetMapping("/{id}")
    public Result<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollment> enrollment = enrollmentService.getEnrollmentById(id);
        return enrollment.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }
    /**
     * @param enrollment
     * @return {@link Result<Enrollment>}
     * @Description 添加选课信息
     */
    @PostMapping
    public Result<Enrollment> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment savedEnrollment = enrollmentService.addEnrollment(enrollment);
        return ResultUtils.success(savedEnrollment);
    }
    /**
     * @param id
     * @Description 删除选课信息
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResultUtils.success(null);
    }
    /**
     * @param id
     * @param enrollment
     * @return {@link Result<Enrollment>}
     * @Description 更新选课信息
     */
    @PutMapping("/{id}")
    public Result<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        enrollment.setId(id);
        Optional<Enrollment> updatedEnrollment = enrollmentService.updateEnrollment(enrollment);
        return updatedEnrollment.map(ResultUtils::success).orElseGet(() -> ResultUtils.success(null));
    }
}
}