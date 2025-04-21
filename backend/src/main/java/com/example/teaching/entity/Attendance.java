package com.example.teaching.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "first_check_in")
    private Timestamp firstCheckIn;
    @Column(name = "second_check_in")
    private Timestamp secondCheckIn;
    @Column(name = "third_check_in")
    private Timestamp thirdCheckIn;
    @Column(name = "fourth_check_in")
    private Timestamp fourthCheckIn;
    @Column(name = "is_qualified")
    private Boolean isQualified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Timestamp getFirstCheckIn() {
        return firstCheckIn;
    }

    public void setFirstCheckIn(Timestamp firstCheckIn) {
        this.firstCheckIn = firstCheckIn;
    }

    public Timestamp getSecondCheckIn() {
        return secondCheckIn;
    }

    public void setSecondCheckIn(Timestamp secondCheckIn) {
        this.secondCheckIn = secondCheckIn;
    }

    public Timestamp getThirdCheckIn() {
        return thirdCheckIn;
    }

    public void setThirdCheckIn(Timestamp thirdCheckIn) {
        this.thirdCheckIn = thirdCheckIn;
    }

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