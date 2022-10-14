package com.example.mywebapp.service.IMPL;

import com.example.mywebapp.entity.Student;
import com.example.mywebapp.repo.StudentRepo;
import com.example.mywebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> listAll(){
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    public Student get(int id){
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
            return student.get();
        }else {
            throw new NotFoundException("not here");
        }
    }
    public void deleteStudent(int id){
        studentRepo.deleteById(id);
    }
}
