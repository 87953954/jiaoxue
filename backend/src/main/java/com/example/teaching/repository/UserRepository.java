package com.example.teaching.repository;

import com.example.teaching.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository 接口
 * 该接口用于对 User 实体进行数据库操作。
 * 继承 JpaRepository 接口，提供了基本的 CRUD 操作方法。
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {    
    /**
     * 根据用户名和密码查找用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 匹配的用户，如果没有找到则返回 null
     */
    public User findByUsernameAndPassword(String username, String password);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return 匹配的用户，如果没有找到则返回 null
     */
    public User findByUsername(String username);

    /**
     * 根据邮箱查找用户
     *
     * @param email 邮箱
     * @return 匹配的用户，如果没有找到则返回 null
     */
    Optional<User> findByEmail(String email);

    /**
     * 根据手机号查找用户
     *
     * @param phone 手机号
     * @return 匹配的用户，如果没有找到则返回 null
     */
    Optional<User> findByPhone(String phone);

    /**
     * 根据用户名判断用户是否存在
     *
     * @param username 用户名
     * @return 如果用户存在则返回 true，否则返回 false
     */
    boolean existsByUsername(String username);

    /**
     * 根据邮箱判断用户是否存在
     *
     * @param email 邮箱
     * @return 如果用户存在则返回 true，否则返回 false
     */
    boolean existsByEmail(String email);

    /**
     * 根据手机号判断用户是否存在
     * @param phone 手机号
     * @return 如果用户存在则返回 true，否则返回 false
     */
    boolean existsByPhone(String phone);
}
