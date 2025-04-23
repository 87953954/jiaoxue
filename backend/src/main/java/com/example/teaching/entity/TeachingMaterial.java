package com.example.teaching.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * TeachingMaterial 实体类
 * 该类代表课程的教学资料。
 */
@Data
@Entity
@Table(name = "teaching_material")
public class TeachingMaterial {
    /**
     * 教学资料ID，主键，自动生成
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 课程ID，不能为空
     */
    @NotNull(message = "Course ID is required")
    @Column(name = "course_id")
    private Long courseId;

    /**
     * 教师ID，不能为空
     */
    @NotNull(message = "Teacher ID is required")
    @Column(name = "teacher_id")
    private Long teacherId;

    /**
     * 教学资料标题，不能为空，最大长度为100个字符
     */
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title cannot be longer than 100 characters")
    private String title;

    /**
     * 教学资料内容，不能为空，最大长度为500个字符
     */
    @NotBlank(message = "Content is required")
    @Size(max = 500, message = "Content cannot be longer than 500 characters")
    private String content;

    /**
     * 文件Url，教学资料链接地址
     */
    private String fileUrl;

    
}
