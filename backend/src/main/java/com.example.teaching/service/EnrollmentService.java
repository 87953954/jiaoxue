package com.example.teaching.service;

import com.example.teaching.entity.Enrollment;
import com.example.teaching.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;    

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}