package com.example.teaching.repository;

import com.example.teaching.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import java.util.List;

/**
 * AttendanceRepository 接口
 * 该接口用于对 Attendance 实体进行数据库操作。
 * 继承了 JpaRepository 接口，提供了基本的 CRUD 操作。
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    /**
     * 根据学生ID查找考勤记录
     * @param studentId 学生ID
     * @return 找到的考勤记录列表
     */
    List<Attendance> findByStudentId(Long studentId);
    /**
     * 根据课程ID查找考勤记录
     * @param courseId 课程ID
     * @return 找到的考勤记录列表
     */
    List<Attendance> findByCourseId(Long courseId);

    /**
     * 根据学生ID和课程ID查找考勤记录
     * @param studentId 学生ID
     * @param courseId 课程ID
     * @return 找到的考勤记录列表
     */
    List<Attendance> findByStudentIdAndCourseId(Long studentId, Long courseId);

    /**
     * 查找在指定时间范围内签到的考勤记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 找到的考勤记录列表
     */
    List<Attendance> findByCheckInTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
    /**
     * 查找在指定时间范围内签退的考勤记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 找到的考勤记录列表
     */
    List<Attendance> findByCheckOutTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}