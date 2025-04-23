package com.example.teaching.repository;

import com.example.teaching.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
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

    /**
     * 根据学生ID和课程ID查找缴费记录
     *
     * @param studentId 学生ID
     * @param courseId 课程ID
     * @return 找到的缴费记录列表
     */
    List<Payment> findByStudentIdAndCourseId(Long studentId, Long courseId);

    /**
     * 根据支付时间范围查找缴费记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 找到的缴费记录列表
     */
    List<Payment> findByPaymentTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 根据支付状态查找缴费记录
     * @param paymentStatus 支付状态
     * @return 找到的缴费记录列表
     */
    List<Payment> findByPaymentStatus(String paymentStatus);
}