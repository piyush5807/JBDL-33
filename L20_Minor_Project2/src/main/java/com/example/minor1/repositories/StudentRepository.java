package com.example.minor1.repositories;

import com.example.minor1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository  -- Not mandatory because SimpleJPARepository class has a repository annotation
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
