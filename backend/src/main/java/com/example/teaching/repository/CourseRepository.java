package com.example.teaching.repository;

import com.example.teaching.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * CourseRepository 接口
 * 该接口用于对 Course 实体进行数据库操作。
 * 继承了 JpaRepository 接口，提供了基本的 CRUD 操作。
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    /**
     * 根据教师 ID 查找课程
     * @param teacherId 教师 ID
     * @return 属于该教师的所有课程列表
     */
    List<Course> findByTeacherId(Long teacherId);

    /**
     * 根据学生 ID 查找课程
     * @param studentId 学生 ID
     * @return 该学生选修的所有课程列表
     */
    @Query("SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId")
    List<Course> findByStudentId(Long studentId);
}