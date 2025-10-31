package com.example.demo.service;


import com.example.demo.dio.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class Studentservice {
@Autowired
private StudentRepo studentrepo;

    public Student getstudentbyid(){
      return   studentrepo.getstudentbyid();

      

    }
}
