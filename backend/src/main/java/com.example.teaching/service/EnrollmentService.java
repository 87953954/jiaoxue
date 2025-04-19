package com.example.teaching.service;

import com.example.teaching.entity.Enrollment;
import com.example.teaching.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;    

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Optional<Enrollment> updateEnrollment(Enrollment enrollment) {
        Optional<Enrollment> existingEnrollment = enrollmentRepository.findById(enrollment.getId());
        if (existingEnrollment.isPresent()) {
            return Optional.of(enrollmentRepository.save(enrollment));
        }
        return Optional.empty();
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}