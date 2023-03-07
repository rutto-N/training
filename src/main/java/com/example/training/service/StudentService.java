package com.example.training.service;

import com.example.training.model.Student;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){

        return studentRepository.findAll();
    }

    public String addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalArgumentException("The email provided is already taken");
        }
        studentRepository.save(student);
        return "Student created successfully";
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)){
            throw new IllegalArgumentException("Student with Id "+studentId+" does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Long id, String name, String email) {


    }
}
