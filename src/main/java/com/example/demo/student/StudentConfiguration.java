package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return args -> {

            Student s1 = new Student("Prakash", LocalDate.of(1998,9,18),"prakash@gmail.com");
            Student s2 = new Student("Phoenix", LocalDate.of(1998,8,18),"prakash@gmail.com");

            repository.saveAll(Arrays.asList(s1,s2));
        };
    }

}
