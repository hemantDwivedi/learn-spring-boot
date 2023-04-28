package com.project.restapi.controller;

import com.project.restapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        // return new ResponseEntity<>(new Student(1, "Hemant Kumar"), HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "hemant")
                .body(new Student(1, "hemant kumar"));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "hemant kumar"));
        students.add(new Student(2, "hello world"));
        return ResponseEntity.ok(students);
    }

    // PATH Variable
    // {id} - URI template
    @GetMapping("/{id}/{name}")
    public ResponseEntity<Student> pathStudent(@PathVariable int id, @PathVariable String name){
        return ResponseEntity.ok(new Student(id, name));
    }

    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestParam(@RequestParam int id, @RequestParam String name){
        return ResponseEntity.ok(new Student(id, name));
    }

    // HTTP POST Request
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        return ResponseEntity.ok(student);
    }


    // HTTP PUT Request - update existing resource
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
        System.out.println(student.getName());
        return ResponseEntity.ok(student);
    }

    // HTTP DELETE Request - delete existing resource
    @DeleteMapping("/students/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return ResponseEntity.ok("success");
    }
}
