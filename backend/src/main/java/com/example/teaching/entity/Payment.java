package com.example.teaching.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import lombok.Data;

/**
 * Payment 实体类
 * 该类代表学生的缴费记录。
 */
@Data
@Entity
@Table(name = "payment")
public class Payment {
    /**
     * 缴费记录ID，主键，自动生成
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学生ID，不能为空
     */
    @NotNull(message = "Student ID is required")
    @Column(name = "student_id")
    private Long studentId;

    /**
     * 课程ID，不能为空
     */
    @NotNull(message = "Course ID is required")
    @Column(name = "course_id")
    private Long courseId;

    /**
     * 缴费金额，不能为空
     */
    @NotNull(message = "Amount is required")
    @Column(name = "amount")
    private Double amount;
    /**
     * 缴费截图路径
     */
    @Column(name = "payment_screenshot")
    private String paymentScreenshot;
    /**
     * 缴费状态
     */
    @Column(name = "status")
    private String status;
    @Column(name = "auditor")
    private Long auditor;
}