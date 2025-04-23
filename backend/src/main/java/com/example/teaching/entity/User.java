package com.example.teaching.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // 导入NotBlank注解
import jakarta.validation.constraints.Size; // 导入Size注解
import lombok.Data;

import java.util.List;
/**
 * @Entity
 * @Table(name = "user")
 * 用户实体类
 * 对应数据库中的user表
 */
@Data
@Entity
@Table(name = "user")
public class User {
    /**
     * @Id 主键
     * @GeneratedValue(strategy = GenerationType.IDENTITY) 自增长策略
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * @NotBlank(message = "Username is required") 用户名不能为空
     * @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters") 用户名长度必须在3-20个字符之间
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 20, message = "用户名长度必须在3-20个字符之间")
    private String username;
    /**
     * @NotBlank(message = "Password is required") 密码不能为空
     * @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters") 密码长度必须在6-20个字符之间
     * 用户密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间")
    private String password;
    /**
     * @NotBlank(message = "Email is required") 邮箱不能为空
     * 用户邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;
    /**
     * 用户角色 例如: student teacher admin
     */
    private String role;
    /**
     * @Column(name = "name") 对应数据库中name列
     * 用户姓名
     */
    @Column(name = "name")
    private String name;
    /**
     * @Column(name = "phone_number") 对应数据库中phone_number列
     * 用户手机号
     */
    @Column(name = "phone_number")
    private String phone;

    /**
     * @ManyToMany(mappedBy = "students")  多对多关系，mappedBy = "students"表示Course类中的students属性维护关联关系
     *  用户（学生）可以选多个课程
     *  关系维护在Course实体类中
     */
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    /**
     * @OneToMany(mappedBy = "teacher") 一对多关系，mappedBy = "teacher" 表示Course类中的teacher属性维护关联关系
     * 一个用户（老师）可以教多门课程
     * 关系维护在Course实体类中
     */
    @OneToMany(mappedBy = "teacher")
    private List<Course> taughtCourses;
}