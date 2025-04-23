package com.example.teaching.service;

import com.example.teaching.entity.User;
import com.example.teaching.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * UserService 类
 * 该类负责处理用户相关的业务逻辑。
 */
@Service
public class UserService {
    /**
     * 自动注入 UserRepository，用于数据库操作
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 获取所有用户
     *
     * @return 用户列表
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 创建用户
     *
     * @param user 用户对象
     * @return 创建后的用户对象
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 根据ID获取用户
     *
     * @param id 用户ID
     * @return 找到的用户对象，如果不存在则返回 null
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * 更新用户信息
     *
     * @param user 用户对象
     * @return 更新后的用户对象，如果用户不存在则返回 null
     */
    public User updateUser(User user) {
        // 检查用户是否存在
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }

    /**
     * 根据ID删除用户
     *
     * @param id 用户ID
     */
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * 注册用户
     *
     * @param user 用户对象
     * @return 注册后的用户对象
     */
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户对象，如果用户名或密码错误则返回 null
     */
    public User login(String username, String password) {
        // 根据用户名查找用户
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(username));

        // 检查用户是否存在且密码是否匹配
        return optionalUser.filter(user -> user.getPassword().equals(password)).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 更新用户密码
     *
     * @param username    用户名
     * @param newPassword 新密码
     * @return 更新密码后的用户对象，如果用户不存在则返回 null
     */
    public User updatePassword(String username, String newPassword) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(username));
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(newPassword);
            return userRepository.save(user);
        }
        return null;
    }

    /**
     * 忘记密码，重置密码
     *
     * @param username    用户名
     * @param newPassword 新密码
     * @return 更新密码后的用户对象，如果用户不存在则返回 null
     */
    public User forgetPassword(String username, String newPassword) {
        return updatePassword(username,newPassword);
    }
}

