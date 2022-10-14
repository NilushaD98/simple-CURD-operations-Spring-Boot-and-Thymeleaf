package com.example.mywebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",length = 100)
    private int ID;

    @Column(name="password" , length = 15, nullable = false)
    private String password;

    @Column(name = "firstname",length = 100,nullable = false)
    private  String firstName;

    @Column(name = "lastname",length = 100,nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
