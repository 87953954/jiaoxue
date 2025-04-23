package com.example.teaching.repository;

import com.example.teaching.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    /**
     * 根据学生ID查找选课记录
     * @param studentId 学生ID
     * @return 找到的选课记录列表
     */
    List<Enrollment> findByStudentId(Long studentId);

    /**
     * 根据课程ID查找选课记录
     * @param courseId 课程ID
     * @return 找到的选课记录列表
     */
    List<Enrollment> findByCourseId(Long courseId);

    /**
     * 查找在给定时间范围内的选课记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 找到的选课记录列表
     */
    List<Enrollment> findByEnrollmentTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
    /**
     * 根据学生ID和课程ID查找选课记录
     * @param studentId 学生ID
     * @param courseId 课程ID
     * @return 找到的选课记录列表
     */
    List<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);
}