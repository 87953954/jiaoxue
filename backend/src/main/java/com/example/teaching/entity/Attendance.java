package com.example.teaching.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
/**
 * Attendance 实体类
 * 该类代表学生的考勤记录。
 */
@Entity
@Table(name = "attendance")
public class Attendance {
    /**
     * 考勤记录ID，主键，自动生成
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 学生ID，不能为空
     */
    @NotNull(message = "Student ID is required")
    @Column(name = "student_id")
    private Long studentId;
    /**
     * 课程ID，不能为空
     */
    @NotNull(message = "Course ID is required")
    @Column(name = "course_id")
    private Long courseId;
    /**
     * 考勤状态，不能为空，最大长度为20个字符
     */
    @NotBlank(message = "Status is required")
    @Size(max = 20, message = "Status cannot be longer than 20 characters")
    private String status;
    /**
     * 第一次签到时间
     */
    @Column(name = "first_check_in")
    private Timestamp firstCheckIn;
    /**
     * 第二次签到时间
     */
    @Column(name = "second_check_in")
    private Timestamp secondCheckIn;
    /**
     * 第三次签到时间
     */
    @Column(name = "third_check_in")
    private Timestamp thirdCheckIn;
    /**
     * 第四次签到时间
     */
    @Column(name = "fourth_check_in")
    private Timestamp fourthCheckIn;
    /**
     * 签退时间
     */
    @Column(name = "check_out")
    private Timestamp checkOutTime;
    /**
     * 是否合格
     */
    @Column(name = "is_qualified")
    private Boolean isQualified;

    /**
     * 获取考勤状态
     *
     * @return 考勤状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置考勤状态
     *
     * @param status 考勤状态
     */
    public void setStatus(String status) {
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取学生ID
     *
     * @return 学生ID
     */
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取课程ID
     *
     * @return 课程ID
     */
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取第一次签到时间
     *
     * @return 第一次签到时间
     */
    public Timestamp getFirstCheckIn() {
        return firstCheckIn;
    }

    public void setFirstCheckIn(Timestamp firstCheckIn) {
        this.firstCheckIn = firstCheckIn;
    }

    /**
     * 获取第二次签到时间
     *
     * @return 第二次签到时间
     */
    public Timestamp getSecondCheckIn() {
        return secondCheckIn;
    }

    public void setSecondCheckIn(Timestamp secondCheckIn) {
        this.secondCheckIn = secondCheckIn;
    }

    /**
     * 获取第三次签到时间
     *
     * @return 第三次签到时间
     */
    public Timestamp getThirdCheckIn() {
        return thirdCheckIn;
    }

    public void setThirdCheckIn(Timestamp thirdCheckIn) {
        this.thirdCheckIn = thirdCheckIn;
    }

    /**
     * 获取第四次签到时间
     *
     * @return 第四次签到时间
     */
    public Timestamp getFourthCheckIn() {
        return fourthCheckIn;
    }

    public void setFourthCheckIn(Timestamp fourthCheckIn) {
        this.fourthCheckIn = fourthCheckIn;
    }

    public Boolean getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Boolean qualified) {
        isQualified = qualified;
    }
}