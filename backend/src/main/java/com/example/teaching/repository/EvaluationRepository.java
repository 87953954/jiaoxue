package com.example.teaching.repository;

import com.example.teaching.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * EvaluationRepository 接口
 * 该接口用于对 Evaluation 实体进行数据库操作。
 * 继承了 JpaRepository 接口，提供了基本的 CRUD 操作。
 */
@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    /**
     * 根据学生ID查找评价记录
     *
     * @param studentId 学生ID
     * @return 找到的评价记录列表
     */
    List<Evaluation> findByStudentId(Long studentId);

    /**
     * 根据课程ID查找评价记录
     *
     * @param courseId 课程ID
     * @return 找到的评价记录列表
     */
    List<Evaluation> findByCourseId(Long courseId);

    /**
     * 根据教师ID查找评价记录
     * @param teacherId 教师ID
     * @return 找到的评价记录列表
     */
    List<Evaluation> findByTeacherId(Long teacherId);

    /**
     * 根据学生ID和课程ID查找评价记录
     *
     * @param studentId 学生ID
     * @param courseId  课程ID
     * @return 找到的评价记录列表
     */
    List<Evaluation> findByStudentIdAndCourseId(Long studentId, Long courseId);

    /**
     * 根据学生ID和教师ID查找评价记录
     * @param studentId 学生ID
     * @param teacherId 教师ID
     * @return 找到的评价记录列表
     */
    List<Evaluation> findByStudentIdAndTeacherId(Long studentId, Long teacherId);

    /**
     * 根据课程ID和教师ID查找评价记录
     * @param courseId 课程ID, @param teacherId 教师ID
     * @return 找到的评价记录列表
     */
    List<Evaluation> findByCourseIdAndTeacherId(Long courseId, Long teacherId);
}