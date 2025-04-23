package com.example.teaching.controller;

import com.example.teaching.entity.Attendance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.teaching.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

import java.util.List;

/**
 * AttendanceController 类
 * 该类负责处理与 Attendance 实体相关的 HTTP 请求。
 * 提供了考勤管理相关的 API 接口。
 */
@Api(tags = "考勤管理")
@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    
    /**
     * 获取所有考勤记录
     * @return 考勤记录列表
     */
    @ApiOperation("获取所有考勤记录")
    @GetMapping
    public List<Attendance> getAllAttendances() {
        return attendanceService.findAll();
    }

    /**
     * 创建考勤记录
     * @param attendance 要创建的考勤记录对象
     * @return 创建成功的考勤记录对象
     */
    @ApiOperation("创建考勤记录")
    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance createdAttendance = attendanceService.createAttendance(attendance);
        return new ResponseEntity<>(createdAttendance, HttpStatus.CREATED);
    }
    
    /**
     * 根据ID获取考勤记录
     * @param id 考勤记录ID
     * @return 找到的考勤记录
     */
    @ApiOperation("根据ID获取考勤记录")
    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        Attendance attendance = attendanceService.getAttendanceById(id);
        if (attendance != null) {
            return new ResponseEntity<>(attendance, HttpStatus.OK);
        } else {          
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * 更新考勤记录
     * @param attendance 要更新的考勤记录对象
     * @return 更新后的考勤记录对象
     */
    @ApiOperation("更新考勤记录")
    @PutMapping
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance) {
        Attendance updatedAttendance = attendanceService.updateAttendance(attendance);
        return new ResponseEntity<>(updatedAttendance, HttpStatus.OK);
    }
    
    /**
     * 根据ID删除考勤记录
     * @param id 要删除的考勤记录ID
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendanceById(@PathVariable Long id) {
        attendanceService.deleteAttendanceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    
    /**
     * 学生签到
     * @param attendance 包含学生ID和课程ID的考勤对象
     * @return 签到成功的考勤记录对象
     */
    @ApiOperation("学生签到")
    @PostMapping("/checkIn")
    public Attendance checkIn(@RequestBody Attendance attendance) {
        return attendanceService.checkIn(attendance.getStudentId(), attendance.getCourseId());
    }
    
    /**
     * 学生签退
     * @param attendance 包含学生ID和课程ID的考勤对象
     * @return 签退成功的考勤记录对象
     */
    @ApiOperation("学生签退")
    @PostMapping("/checkOut")
    public Attendance checkOut(@RequestBody Attendance attendance) {
        return attendanceService.checkOut(attendance.getStudentId(), attendance.getCourseId());
    }
    
    /**
     * 根据学生ID获取考勤记录
     * @param studentId 学生ID
     * @return 考勤记录列表
     */
    @GetMapping("/byStudent/{studentId}")
    public List<Attendance> getAttendancesByStudentId(@PathVariable Long studentId) {
        return attendanceService.getAttendancesByStudentId(studentId);
    }
    
    /**
     * 根据课程ID获取考勤记录
     * @param courseId 课程ID
     * @return 考勤记录列表
     */
    @GetMapping("/byCourse/{courseId}")
    public List<Attendance> getAttendancesByCourseId(@PathVariable Long courseId) {
        return attendanceService.getAttendancesByCourseId(courseId);
    }
}
