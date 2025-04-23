package com.example.teaching.service;

import com.example.teaching.entity.TeachingMaterial;
import com.example.teaching.repository.TeachingMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TeachingMaterialService 类
 * 该类提供了对 TeachingMaterial 实体进行业务操作的服务方法。
 */
@Service
public class TeachingMaterialService {
    @Autowired
    private TeachingMaterialRepository teachingMaterialRepository;

    /**
     * 查找所有教学资料
     * @return 教学资料列表
     */
    public List<TeachingMaterial> findAll() {
        return teachingMaterialRepository.findAll();
    }

    /**
     * 创建教学资料
     * @param teachingMaterial 要创建的教学资料对象
     * @return 创建成功的教学资料对象
     */
    public TeachingMaterial createTeachingMaterial(TeachingMaterial teachingMaterial) {
        return teachingMaterialRepository.save(teachingMaterial);
    }

    /**
     * 根据ID查找教学资料
     * @param id 教学资料ID
     * @return 找到的教学资料，如果不存在则返回 null
     */
    public TeachingMaterial getTeachingMaterialById(Long id) {
        Optional<TeachingMaterial> optionalTeachingMaterial = teachingMaterialRepository.findById(id);
        return optionalTeachingMaterial.orElse(null);
    }

    /**
     * 更新教学资料信息
     * @param teachingMaterial 要更新的教学资料对象
     * @return 更新后的教学资料对象
     */
    public TeachingMaterial updateTeachingMaterial(TeachingMaterial teachingMaterial) {
        return teachingMaterialRepository.save(teachingMaterial);
    }

    /**
     * 根据ID删除教学资料
     * @param id 要删除的教学资料ID
     */
    public void deleteTeachingMaterialById(Long id) {
        teachingMaterialRepository.deleteById(id);
    }

    /**
     * 根据课程ID查找教学资料
     * @param courseId 课程ID
     * @return 找到的教学资料列表
     */
    public List<TeachingMaterial> getTeachingMaterialsByCourseId(Long courseId) {
        return teachingMaterialRepository.findByCourseId(courseId);
    }

    /**
     * 根据教师ID查找教学资料
     * @param teacherId 教师ID
     * @return 找到的教学资料列表
     */
    public List<TeachingMaterial> getTeachingMaterialsByTeacherId(Long teacherId) {
        return teachingMaterialRepository.findByTeacherId(teacherId);
    }
}
