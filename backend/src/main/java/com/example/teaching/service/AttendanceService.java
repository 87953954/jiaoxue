package com.example.teaching.service;

import com.example.teaching.entity.Attendance;
import com.example.teaching.repository.AttendanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * AttendanceService 类
 * 该类提供了对 Attendance 实体进行业务操作的服务方法。
 */
@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    /**
     * 查找所有考勤记录
     *
     * @return 考勤记录列表
     */
    public List<Attendance> findAll() {
        return attendanceRepository.findAll();
    }

    /**
     * 创建考勤记录
     *
     * @param attendance 要创建的考勤记录对象
     * @return 创建成功的考勤记录对象
     */
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    /**
     * 根据ID查找考勤记录
     *
     * @param id 考勤记录ID
     * @return 找到的考勤记录，如果不存在则返回null
     */
    public Attendance getAttendanceById(Long id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
        return optionalAttendance.orElse(null);
    }

    /**
     * 更新考勤记录信息
     *
     * @param attendance 要更新的考勤记录对象
     * @return 更新后的考勤记录对象，如果考勤记录不存在则返回null
     */
    public Attendance updateAttendance(Attendance attendance) {
        // 检查考勤记录是否存在
        if (attendanceRepository.existsById(attendance.getId())) {
            return attendanceRepository.save(attendance);
        }
        return null;
    }

    /**
     * 根据ID删除考勤记录
     *
     * @param id 要删除的考勤记录ID
     */
    public void deleteAttendanceById(Long id) {
        attendanceRepository.deleteById(id);
    }

    /**
     * 学生签到
     *
     * @param studentId 学生ID
     * @param courseId  课程ID
     * @return 签到成功的考勤记录
     */
    @Transactional
    public Attendance checkIn(Long studentId, Long courseId) {
        // 添加签到的逻辑
        Attendance attendance = new Attendance();
        attendance.setStudentId(studentId);
        attendance.setCourseId(courseId);
        return attendanceRepository.save(attendance);
    }

    /**
     * 学生签退
     *
     * @param studentId 学生ID
     * @param courseId  课程ID
     * @return 签退成功的考勤记录
     */
    @Transactional
    public Attendance checkOut(Long studentId, Long courseId) {
        // 添加签退的逻辑
        Attendance attendance = new Attendance();
        attendance.setStudentId(studentId);
        attendance.setCourseId(courseId);
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendancesByStudentId(Long studentId) {
        /**
         * 根据学生ID查找考勤记录
         *
         * @param studentId 学生ID
         * @return 找到的考勤记录列表
         */
        return attendanceRepository.findByStudentId(studentId);
    }

    /**
     * 根据课程ID查找考勤记录
     *
     * @param courseId 课程ID
     * @return 找到的考勤记录列表
     */
    public List<Attendance> getAttendancesByCourseId(Long courseId) {
        return attendanceRepository.findByCourseId(courseId);
    }
}