package com.project.student.controller;

import com.project.student.dto.StudentDto;
import com.project.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;
    // handler method to handle list of students request
    @GetMapping("/students")
    public String listOfStudents(Model model){
        List<StudentDto> students = studentService.listOfStudents();
        System.out.println();
        model.addAttribute("students", students);
        return "students";
    }

    // handler method to handle create student request
    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "new-student";
    }

    // handler method to handle submit student form request
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "new-student";
        }
        studentService.createStudent(studentDto);
        return "redirect:/students";
    }

    // handler method to handle edit student reqeust
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student", studentDto);
        return "edit-student";
    }

    // handler method to handle update student request
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "edit-student";
        }
        studentDto.setId(id);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/students/view/{id}")
    public String viewStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "view-student";
    }
}
