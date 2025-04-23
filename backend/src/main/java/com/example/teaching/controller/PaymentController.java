package com.example.teaching.controller;

import com.example.teaching.entity.Payment;
import com.example.teaching.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * PaymentController 类
 * 该类负责处理与 Payment 实体相关的 HTTP 请求。
 * 提供了缴费管理相关的 API 接口。
 */
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 获取所有缴费记录
     * @return 缴费记录列表
     */
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.findAll();
    }

    /**
     * 创建缴费记录
     * @param payment 要创建的缴费记录对象
     * @return 创建成功的缴费记录对象
     */
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    /**
     * 根据ID获取缴费记录
     * @param id 缴费记录ID
     * @return 找到的缴费记录
     */
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 更新缴费记录信息
     * @param id 要更新的缴费记录ID
     * @param payment 要更新的缴费记录对象
     * @return 更新后的缴费记录对象
     */
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        payment.setId(id);
        return new ResponseEntity<>(paymentService.updatePayment(payment), HttpStatus.OK);
    }

    /**
     * 根据ID删除缴费记录
     * @param id 要删除的缴费记录ID
     * @return 没有返回值
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentById(@PathVariable Long id) {
        paymentService.deletePaymentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 根据学生ID获取缴费记录
     * @param studentId 学生ID
     * @return 缴费记录列表
     */
    @GetMapping("/byStudent/{studentId}")
    public List<Payment> getPaymentsByStudentId(@PathVariable Long studentId) {
        return paymentService.getPaymentsByStudentId(studentId);
    }

    /**
     * 根据课程ID获取缴费记录
     * @param courseId 课程ID
     * @return 缴费记录列表
     */
    @GetMapping("/byCourse/{courseId}")
    public List<Payment> getPaymentsByCourseId(@PathVariable Long courseId) {
        return paymentService.getPaymentsByCourseId(courseId);
    }

    /**
     * 校验缴费记录
     * @param paymentId 缴费记录ID
     * @return 缴费记录
     */
    @PostMapping("/checkPayment/{paymentId}")
    public Payment checkPayment(@PathVariable Long paymentId){
        return paymentService.checkPayment(paymentId);
    }
}
