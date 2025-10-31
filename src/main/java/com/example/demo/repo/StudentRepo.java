package com.example.demo.repo;


import com.example.demo.dio.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
    public Student getstudentbyid() {
        return new Student("amr", "60");
    }
}
