package com.example.demo.controler;


import com.example.demo.service.Studentservice;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Studentcontroler {
     @Autowired
    private Studentservice studentservice;

    public  void getstudentbyid(){
        System.out.println(studentservice.getstudentbyid());
    }
}
