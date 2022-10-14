package com.example.mywebapp;

import com.example.mywebapp.entity.Student;
import com.example.mywebapp.repo.StudentRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public  void testAddNew(){
        Student student = new Student();
        student.setEmail("Nilusha@gmail.com");
        student.setFirstName("Nilusha");
        student.setLastName("Dissanayaka");
        student.setPassword("Nilusha@076");
        Student student1 = studentRepo.save(student);

        Assertions.assertThat(student1).isNotNull();
        Assertions.assertThat(student1.getID()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<Student> studentIterable = studentRepo.findAll();
        Assertions.assertThat(studentIterable).hasSizeGreaterThan(0);
        for (Student student : studentIterable){
            System.out.println(student.toString());
        }
    }
    @Test
    public void testUpdate(){
        Integer userID = 1;
        Optional<Student> optionalStudent = studentRepo.findById(userID);
        Student student = optionalStudent.get();
        student.setPassword("12345");
        studentRepo.save(student);

        Student updateStudent = studentRepo.findById(userID).get();
        Assertions.assertThat(updateStudent.getPassword()).isEqualTo("12345");
    }
    @Test
    public void testGet(){
        int userID = 1;
        Optional<Student> student = studentRepo.findById(userID);
        Assertions.assertThat(student).isPresent();
        System.out.println(student.get());
    }
    @Test
    public void test(){
        int userID = 1;
        studentRepo.deleteById(userID);
        Optional<Student> student = studentRepo.findById(userID);
        Assertions.assertThat(student).isNotPresent();
    }
}
