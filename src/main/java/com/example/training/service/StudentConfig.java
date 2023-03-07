package com.example.training.service;

import com.example.training.model.Student;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {

        Student one = new Student();
        one.setName("Nancy Rutto");
        one.setDateOfBirth(LocalDate.of(1990, 5, 21));
        one.setEmail("ruttonancy24@gmail.com");

        Student two = new Student();
        two.setName("Nancy Toi");
        two.setDateOfBirth(LocalDate.of(2000, 6, 22));
        two.setEmail("ruttonancy244@gmail.com");

        Student three = new Student();
        three.setName("Nancy Tee");
        three.setDateOfBirth(LocalDate.of(1996, 7, 23));
        three.setEmail("ruttonancy245@gmail.com");

        return args -> {
            studentRepository.saveAll(List.of(one,two,three));
        };
    }
}
