package com.example.teaching.repository;

import com.example.teaching.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    /**
     * 根据教师姓名查找教师
     * @param teacherName 教师姓名
     * @return 教师列表
     */
    List<Teacher> findByTeacherName(String teacherName);

    /**
     * 根据邮箱查找教师
     * @param email 邮箱
     * @return 教师
     */
    Teacher findByEmail(String email);

    /**
     * 根据电话号码查找教师
     * @param phone 电话号码
     * @return 教师
     */
    Teacher findByPhone(String phone);

    /**
     * 检查是否存在具有指定邮箱的教师
     * @param email 邮箱
     * @return 如果存在则返回 true，否则返回 false
     */
    boolean existsByEmail(String email);

    /**
     * 检查是否存在具有指定电话号码的教师
     * @param phone 电话号码
     * @return 如果存在则返回 true，否则返回 false
     */
    boolean existsByPhone(String phone);
}
}