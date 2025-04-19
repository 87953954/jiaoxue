package com.example.teaching.controller;

import com.example.teaching.entity.Enrollment;
import com.example.teaching.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private  EnrollmentService enrollmentService;

    @GetMapping
    public List<Enrollment> getAllEnrollment() {
        return enrollmentService.getAllEnrollment();
    }
}