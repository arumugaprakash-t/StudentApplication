package com.example.demo.student;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(name="student_sequence",sequenceName = "student_name",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private long id;
    private String name;
    @Transient
    private int age;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dob;
    private String email;

    public Student(){

    }

    public Student(long id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;

        this.dob = dob;
        this.email = email;
    }

    public Student(String name,  LocalDate dob, String email) {
        this.name = name;

        this.dob = dob;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
