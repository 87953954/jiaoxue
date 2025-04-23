package com.example.teaching.service;

import com.example.teaching.entity.Payment;
import com.example.teaching.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(Long id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.orElse(null);
    }

    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }

    public List<Payment> getPaymentsByStudentId(Long studentId) {
        return paymentRepository.findByStudentId(studentId);
    }

    public List<Payment> getPaymentsByCourseId(Long courseId) {
        return paymentRepository.findByCourseId(courseId);
    }

    public Payment checkPayment(Long paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        Payment payment = optionalPayment.orElse(null);
        // add some logic for check payment
        return payment;
    }

}