package com.example.teaching.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import com.example.teaching.entity.Evaluation;
import com.example.teaching.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * EvaluationController 类
 * 该类负责处理与 Evaluation 实体相关的 HTTP 请求。
 * 提供了评价管理相关的 API 接口。
 */
@Tag(name = "评价管理")
@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;
    /**
     * 获取所有评价记录
     * @return 评价记录列表
     */
    @Operation(summary = "获取所有评价")
    @GetMapping
    public List<Evaluation> getAllEvaluations() {
        return evaluationService.findAll();
    }

    @Operation(summary = "创建评价")
    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation createdEvaluation = evaluationService.createEvaluation(evaluation);
        return new ResponseEntity<>(createdEvaluation, HttpStatus.CREATED);
    }

    /**
     * 根据ID获取评价记录
     * @param id  评价记录ID
     * @return 找到的评价记录
     */
    /**
     */

    @Operation(summary = "根据ID获取评价")
    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable Long id) {
        Evaluation evaluation = evaluationService.getEvaluationById(id);
        if (evaluation != null) {
            return new ResponseEntity<>(evaluation, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 更新评价记录信息
     * @param evaluation 要更新的评价记录对象
     * @return 更新后的评价记录对象
     */

    @Operation(summary = "更新评价信息")
    @PutMapping
    public ResponseEntity<Evaluation> updateEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation updatedEvaluation = evaluationService.updateEvaluation(evaluation);
        return new ResponseEntity<>(updatedEvaluation, HttpStatus.OK);
    }
    /**
     * 根据ID删除评价记录
     * @param id  要删除的评价记录ID
     * @return 操作结果
     */
    @Operation(summary = "根据ID删除评价")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluationById(@PathVariable Long id) {
        evaluationService.deleteEvaluationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /**
     * 根据学生ID查找评价记录
     * @param studentId  学生ID
     * @return 找到的评价记录列表
     */
    @Operation(summary = "根据学生ID获取评价")
    @GetMapping("/byStudent/{studentId}")
    public List<Evaluation> getEvaluationsByStudentId(@PathVariable Long studentId) {
        return evaluationService.getEvaluationsByStudentId(studentId);
    }

    /**
     * 根据课程ID查找评价记录
     * @param courseId  课程ID
     * @return 找到的评价记录列表
     */
    @Operation(summary = "根据课程ID获取评价")
    @GetMapping("/byCourse/{courseId}")
    public List<Evaluation> getEvaluationsByCourseId(@PathVariable Long courseId) {
        return evaluationService.getEvaluationsByCourseId(courseId);
    }
    /**
     * 根据教师ID查找评价记录
     * @param teacherId 教师ID
     * @return 找到的评价记录列表
     */
    @Operation(summary = "根据老师ID获取评价")
    @GetMapping("/byTeacher/{teacherId}")
    public List<Evaluation> getEvaluationsByTeacherId(@PathVariable Long teacherId){return evaluationService.getEvaluationsByTeacherId(teacherId);}
}
