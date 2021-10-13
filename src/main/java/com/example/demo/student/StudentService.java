package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){

        return studentRepository.findAll();
    }

    public void add(Student student) {
        Optional<Student> studentEmails = studentRepository.findStudentByEmail(student.getEmail());
        //System.out.println(student.getName());
        if(studentEmails.isPresent()){
            throw new IllegalArgumentException("Email already present");
        }
        studentRepository.save(student);
    }
}
