package com.example.teaching.controller;

import com.example.teaching.entity.Payment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.teaching.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "缴费管理")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @ApiOperation("获取所有缴费记录")
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.findAll();
    }

    @ApiOperation("创建缴费记录")
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @ApiOperation("根据ID获取缴费记录")
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation("更新缴费记录")
    @PutMapping
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(payment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据ID删除缴费记录")
    public ResponseEntity<Void> deletePaymentById(@PathVariable Long id) {
        paymentService.deletePaymentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
