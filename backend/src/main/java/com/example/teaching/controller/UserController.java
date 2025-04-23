package com.example.teaching.controller;

import com.example.teaching.entity.User;
import com.example.teaching.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

/**
 * UserController 类
 * 该类处理与用户相关的 HTTP 请求，例如获取用户列表、创建用户、更新用户信息、删除用户等。
 * 使用了 Spring MVC 的 @RestController 注解，表示这是一个 RESTful 风格的控制器。
 * 使用了 Swagger 的 @Api 注解，用于在 Swagger 文档中对该控制器进行分组。
 */
@Tag(name = "用户管理")
@RestController
@RequestMapping("/api/users")
public class UserController {


    /**
     * 自动注入 UserService 实例
     */
    @Autowired
    private UserService userService;

    /**
     * 获取所有用户
     * @return 用户列表
     */
    @Operation(summary = "获取所有用户")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    /**
     * 创建用户
     * @param user 要创建的用户对象
     * @return 创建成功的用户对象
     */
    @Operation(summary = "创建用户")
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 找到的用户对象，如果不存在则返回 404 错误
     */
    @Operation(summary = "根据ID获取用户")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * 更新用户
     * @param user 要更新的用户对象
     * @return 更新后的用户对象
     */
    @Operation(summary = "更新用户")
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    /**
     * 根据ID删除用户
     * @param id 要删除的用户ID
     * @return 204 No Content 响应
     */
    @Operation(summary = "根据ID删除用户",description = "根据ID删除用户")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /**
     * 用户注册
     * @param user 要注册的用户对象
     * @return 注册成功的用户对象
     */
    @Operation(summary = "用户注册", description = "注册一个新的用户")
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, registeredUser != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    /**
     * 用户登录
     * @param user 包含用户名和密码的用户对象
     * @return 登录成功的用户对象，如果登录失败则返回 401 Unauthorized 错误
     */
    @Operation(summary = "用户登录", description = "用户登录")
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = userService.login(user.getUsername(), user.getPassword());

        return new ResponseEntity<>(loggedInUser, loggedInUser != null ? HttpStatus.OK : HttpStatus.UNAUTHORIZED);
    }

    /**
     * 根据用户名获取用户
     * @param username 要查找的用户名
     * @return 找到的用户对象，如果不存在则返回 404 Not Found 错误
     */
    @Operation(summary = "根据用户名获取用户", description = "根据用户名获取用户信息")
    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return new ResponseEntity<>(user, user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    /**
     * 更新用户密码
     * @param user 包含用户名和密码的用户对象
     * @return 更新成功的用户对象，如果用户不存在则返回 404 Not Found 错误
     */
    @Operation(summary = "更新用户密码", description = "更新用户密码")
    @PutMapping("/updatePassword")
    public ResponseEntity<User> updatePassword(@RequestBody User user) {
        User updatedUser = userService.updatePassword(user.getUsername(),user.getPassword());
        return new ResponseEntity<>(updatedUser, updatedUser != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
     /**
     * 忘记用户密码
     * @param user 包含用户名和密码的用户对象
     */
    @Operation(summary = "忘记密码")
    @PutMapping("/forgetPassword")
    public ResponseEntity<User> forgetPassword(@RequestBody User user) {
        User updatedUser = userService.forgetPassword(user.getUsername(),user.getPassword());
        return new ResponseEntity<>(updatedUser, updatedUser != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}