package com.example.teaching.service;

import com.example.teaching.entity.Teacher;
import com.example.teaching.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> updateTeacher(Teacher teacher) {
        if (teacherRepository.existsById(teacher.getId())) {
            return Optional.of(teacherRepository.save(teacher));
        }
        return Optional.empty();
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}