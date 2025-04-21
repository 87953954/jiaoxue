package com.example.teaching.controller;

import com.example.teaching.entity.Attendance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.teaching.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;
import java.util.List;

@Api(tags = "考勤管理")
@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @ApiOperation("获取所有考勤记录")
    @GetMapping
    public List<Attendance> getAllAttendances() {
        return attendanceService.findAll();
    }

    @ApiOperation("创建考勤记录")
    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance createdAttendance = attendanceService.createAttendance(attendance);
        return new ResponseEntity<>(createdAttendance, HttpStatus.CREATED);
    }

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

    @ApiOperation("更新考勤记录")
    @PutMapping
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance) {
        Attendance updatedAttendance = attendanceService.updateAttendance(attendance);
        return new ResponseEntity<>(updatedAttendance, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendanceById(@PathVariable Long id) {
        attendanceService.deleteAttendanceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

