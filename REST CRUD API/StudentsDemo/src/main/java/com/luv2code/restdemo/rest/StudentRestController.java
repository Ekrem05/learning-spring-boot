package com.luv2code.restdemo.rest;

import com.luv2code.restdemo.entity.Student;
import com.luv2code.restdemo.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private static final List<Student> students = new ArrayList<Student>(List.of(new Student("John","Doe"),
            new Student("Lana","Gerry"),
            new Student("Zoe","Ronald"),
            new Student("Ema","Fill"),
            new Student("Alex","Marcus"),
            new Student("Benny","Daniel")));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/student/{firstName}")
    public List<Student> getStudent(@PathVariable("firstName") String firstName){
        List<Student> list = students.stream().filter(s->s.getFirstName().equalsIgnoreCase(firstName)).toList();
        if(list.isEmpty()){
            throw new StudentNotFoundException("Student with this name does not exist");
        }
        return list;
    }
}
