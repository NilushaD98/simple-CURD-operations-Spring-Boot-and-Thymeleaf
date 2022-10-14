package com.example.mywebapp.repo;

import com.example.mywebapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface StudentRepo extends CrudRepository<Student,Integer> {
}
