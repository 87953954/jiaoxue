package com.example.teaching.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Course 实体类
 * 该类代表系统中的课程信息。
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    /**
     * 课程ID，主键，自动生成。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 课程名称，不能为空，最大长度为 50 个字符。
     */
    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be up to 50 characters")
    private String name;

    /**
     * 课程描述，不能为空，最大长度为 200 个字符。
     */
    @NotBlank(message = "Description is required")
    @Size(max = 200, message = "Description must be up to 200 characters")
    private String description;

    /**
     * 课程学时。
     */
    private Integer classHour;

    /**
     * 授课地点。
     */
    private String location;

    /**
     * 教师信息，不能为空。
     * 多对一关系：多个课程可以由同一个教师教授，一个课程只能由一个教师教授。
     * @ManyToOne 表示多对一关系。
     * @JoinColumn(name = "teacher_id") 指定外键列为 teacher_id。
     */
    @NotNull(message = "Teacher is required")
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    /**
     * 学生列表。
     * 多对多关系：一个课程可以被多个学生选修，一个学生可以选择多个课程。
     * @ManyToMany 表示多对多关系。
     * @JoinTable 配置中间表 course_student，包含 course_id 和 student_id 外键。
     */
    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<User> students;

    /**
     * 获取课程描述。
     * 课程描述不能为空，最大长度为 200 个字符。
     * @return 课程描述。
     */
    @NotBlank(message = "Description is required")
    @Size(max = 200, message = "Description must be up to 200 characters")
    public String getDescription() {
        return description;
    }
}