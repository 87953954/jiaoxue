package com.example.teaching.repository;

import com.example.teaching.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * PaymentRepository 接口
 * 该接口用于对 Payment 实体进行数据库操作。
 * 继承了 JpaRepository 接口，提供了基本的 CRUD 操作。
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    /**
     * 根据学生ID查找缴费记录
     *
     * @param studentId 学生ID
     * @return 找到的缴费记录列表
     */
    List<Payment> findByStudentId(Long studentId);

    /**
     * 根据课程ID查找缴费记录
     *
     * @param courseId 课程ID
     * @return 找到的缴费记录列表
     */
    List<Payment> findByCourseId(Long courseId);
}