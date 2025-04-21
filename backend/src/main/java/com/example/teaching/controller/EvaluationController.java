package com.example.teaching.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.teaching.entity.Evaluation;
import com.example.teaching.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Api(tags = "评价管理")
@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;
    @ApiOperation("获取所有评价")
    @GetMapping
    public List<Evaluation> getAllEvaluations() {
        return evaluationService.findAll();
    }

    @ApiOperation("创建评价")
    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation createdEvaluation = evaluationService.createEvaluation(evaluation);
        return new ResponseEntity<>(createdEvaluation, HttpStatus.CREATED);
    }

    @ApiOperation("根据ID获取评价")
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

    @ApiOperation("更新评价信息")
    @PutMapping
    public ResponseEntity<Evaluation> updateEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation updatedEvaluation = evaluationService.updateEvaluation(evaluation);
        return new ResponseEntity<>(updatedEvaluation, HttpStatus.OK);
    }
    @ApiOperation("根据ID删除评价")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluationById(@PathVariable Long id) {
        evaluationService.deleteEvaluationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
