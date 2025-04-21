package com.example.teaching.service;

import com.example.teaching.entity.TeachingMaterial;
import com.example.teaching.repository.TeachingMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachingMaterialService {
    @Autowired
    private TeachingMaterialRepository teachingMaterialRepository;

    public List<TeachingMaterial> findAll() {
        return teachingMaterialRepository.findAll();
    }

    public TeachingMaterial createTeachingMaterial(TeachingMaterial teachingMaterial) {
        return teachingMaterialRepository.save(teachingMaterial);
    }

    public TeachingMaterial getTeachingMaterialById(Long id) {
        Optional<TeachingMaterial> optionalTeachingMaterial = teachingMaterialRepository.findById(id);
        return optionalTeachingMaterial.orElse(null);
    }

    public TeachingMaterial updateTeachingMaterial(TeachingMaterial teachingMaterial) {
        return teachingMaterialRepository.save(teachingMaterial);
    }

    public void deleteTeachingMaterialById(Long id) {
        teachingMaterialRepository.deleteById(id);
    }
}
