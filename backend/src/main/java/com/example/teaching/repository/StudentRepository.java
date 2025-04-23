package com.example.teaching.repository;

import com.example.teaching.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStudentName(String studentName);

    /**
     * 根据邮箱查找学生
     * @param email 邮箱
     * @return 匹配的用户，如果没有找到则返回 null
     */
    Student findByEmail(String email);

    Student findByPhone(String phone);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}