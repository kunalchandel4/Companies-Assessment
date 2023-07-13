package com.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
