package com.example.mywebapp.service;

import com.example.mywebapp.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();

    void save(Student student);
    Student get(int id);
    void deleteStudent(int id);
}
