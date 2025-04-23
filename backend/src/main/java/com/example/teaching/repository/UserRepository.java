package com.example.teaching.repository;

import com.example.teaching.entity.User;
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
}
