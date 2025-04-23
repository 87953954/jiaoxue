package com.example.teaching.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Student ID is required")
    @Column(name = "student_id")
    private Long studentId;
    @NotNull(message = "Course ID is required")
    @Column(name = "course_id")
    private Long courseId;
    @NotNull(message = "Teacher ID is required")
    @Column(name = "teacher_id")
    private Long teacherId;
    @NotNull(message = "Rating is required")
    @Column(name = "score")
    private Integer score;
    @NotBlank(message = "Comment is required")
    @Size(max = 200, message = "Comment cannot be longer than 200 characters")
    @Column(name = "comment")
    private String comment;












}