package com.example.teaching.controller;

import com.example.teaching.entity.TeachingMaterial;
import com.example.teaching.service.TeachingMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "教学资料管理")
@RestController
@RequestMapping("/api/teachingMaterials")
public class TeachingMaterialController {
    @Autowired
    private TeachingMaterialService teachingMaterialService;

    @ApiOperation("获取所有教学资料")
    @GetMapping
    public List<TeachingMaterial> getAllTeachingMaterials() {
        return teachingMaterialService.findAll();
    }

    @ApiOperation("创建教学资料")
    @PostMapping
    public ResponseEntity<TeachingMaterial> createTeachingMaterial(@RequestBody TeachingMaterial teachingMaterial) {
        TeachingMaterial createdTeachingMaterial = teachingMaterialService.createTeachingMaterial(teachingMaterial);
        return new ResponseEntity<>(createdTeachingMaterial, HttpStatus.CREATED);
    }

    @ApiOperation("根据ID获取教学资料")
    @GetMapping("/{id}")
    public ResponseEntity<TeachingMaterial> getTeachingMaterialById(@PathVariable Long id) {
        TeachingMaterial teachingMaterial = teachingMaterialService.getTeachingMaterialById(id);
        if (teachingMaterial != null) {
            return new ResponseEntity<>(teachingMaterial, HttpStatus.OK);
        } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation("更新教学资料信息")
    @PutMapping
    public ResponseEntity<TeachingMaterial> updateTeachingMaterial(@RequestBody TeachingMaterial teachingMaterial) {
        TeachingMaterial updatedTeachingMaterial = teachingMaterialService.updateTeachingMaterial(teachingMaterial);
        return new ResponseEntity<>(updatedTeachingMaterial, HttpStatus.OK);
    }

    @ApiOperation("根据ID删除教学资料")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeachingMaterialById(@PathVariable Long id) {
        teachingMaterialService.deleteTeachingMaterialById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}