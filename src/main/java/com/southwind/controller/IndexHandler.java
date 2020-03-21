package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexHandler {

    @GetMapping("/index")
    public String index(Model model){
        System.out.println("/index.....");

        List<Student> students = new ArrayList<>();
        students.add(new Student(1L,"aa1",11));
        students.add(new Student(2L,"aa2",12));
        students.add(new Student(3L,"aa3",13));
        students.add(new Student(4L,"aa4",14));
        model.addAttribute("list",students);
        return "index";
    }
}
