package com.example.teaching.controller;

import com.example.teaching.entity.TeachingMaterial;
import com.example.teaching.service.TeachingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachingMaterials")
public class TeachingMaterialController {
    @Autowired
    private TeachingMaterialService teachingMaterialService;

    @GetMapping
    public List<TeachingMaterial> getAllTeachingMaterials() {
        return teachingMaterialService.findAll();
    }

    @PostMapping
    public ResponseEntity<TeachingMaterial> createTeachingMaterial(@RequestBody TeachingMaterial teachingMaterial) {
        TeachingMaterial createdTeachingMaterial = teachingMaterialService.createTeachingMaterial(teachingMaterial);
        return new ResponseEntity<>(createdTeachingMaterial, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TeachingMaterial> getTeachingMaterialById(@PathVariable Long id) {
        TeachingMaterial teachingMaterial = teachingMaterialService.getTeachingMaterialById(id);
        if (teachingMaterial != null) {
            return new ResponseEntity<>(teachingMaterial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping
    public ResponseEntity<TeachingMaterial> updateTeachingMaterial(@RequestBody TeachingMaterial teachingMaterial) {
        TeachingMaterial updatedTeachingMaterial = teachingMaterialService.updateTeachingMaterial(teachingMaterial);
        return new ResponseEntity<>(updatedTeachingMaterial, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeachingMaterialById(@PathVariable Long id) {
        teachingMaterialService.deleteTeachingMaterialById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}