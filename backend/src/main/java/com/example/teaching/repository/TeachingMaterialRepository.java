package com.example.teaching.repository;

import com.example.teaching.entity.TeachingMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * TeachingMaterialRepository 接口
 * 该接口用于对 TeachingMaterial 实体进行数据库操作。
 * 继承了 JpaRepository 接口，提供了基本的 CRUD 操作。
 */
@Repository
public interface TeachingMaterialRepository extends JpaRepository<TeachingMaterial, Long> {
    /**
     * 根据课程ID查找教学资料
     * @param courseId 课程ID
     * @return 找到的教学资料列表
     */
    List<TeachingMaterial> findByCourseId(Long courseId);

    /**
     * 根据教师ID查找教学资料
     * @param teacherId 教师ID
     * @return 找到的教学资料列表
     */
    List<TeachingMaterial> findByTeacherId(Long teacherId);

}