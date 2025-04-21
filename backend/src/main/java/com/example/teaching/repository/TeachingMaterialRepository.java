package com.example.teaching.repository;

import com.example.teaching.entity.TeachingMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingMaterialRepository extends JpaRepository<TeachingMaterial, Long> {
}