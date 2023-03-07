package com.example.training.service;

import com.example.training.model.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("select s from Student  s where s.email=?1")
    Optional<Student> findStudentsByEmail(String email);

}
