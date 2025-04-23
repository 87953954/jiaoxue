package com.example.teaching.service;

import com.example.teaching.entity.Evaluation;
import com.example.teaching.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EvaluationService 类
 * 该类提供了对 Evaluation 实体进行业务操作的服务方法。
 */
@Service
public class EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;

    /**
     * 查找所有评价记录
     * @return 评价记录列表
     */
    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }

    /**
     * 创建评价记录
     * @param evaluation 要创建的评价记录对象
     * @return 创建成功的评价记录对象
     */
    public Evaluation createEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    /**
     * 根据ID查找评价记录
     * @param id 评价记录ID
     * @return 找到的评价记录
     */
    public Evaluation getEvaluationById(Long id) {
        Optional<Evaluation> optionalEvaluation = evaluationRepository.findById(id);
        return optionalEvaluation.orElse(null);
    }

    /**
     * 更新评价记录信息
     * @param evaluation 要更新的评价记录对象
     * @return 更新后的评价记录对象
     */
    public Evaluation updateEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    /**
     * 根据ID删除评价记录
     * @param id 要删除的评价记录ID
     */
    public void deleteEvaluationById(Long id) {
        evaluationRepository.deleteById(id);
    }

    /**
     * 根据学生ID查找评价记录
     * @param studentId 学生ID
     * @return 找到的评价记录列表
     */
    public List<Evaluation> getEvaluationsByStudentId(Long studentId) {
        return evaluationRepository.findByStudentId(studentId);
    }

    /**
     * 根据课程ID查找评价记录
     * @param courseId 课程ID
     * @return 找到的评价记录列表
     */
    public List<Evaluation> getEvaluationsByCourseId(Long courseId) {
        return evaluationRepository.findByCourseId(courseId);
    }

    /**
     * 根据教师ID查找评价记录
     * @param teacherId 教师ID
     * @return 找到的评价记录列表
     */
    public List<Evaluation> getEvaluationsByTeacherId(Long teacherId) {
        return evaluationRepository.findByTeacherId(teacherId);
    }
}
