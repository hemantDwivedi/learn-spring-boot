package com.project.student.service;

import com.project.student.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> listOfStudents();

    void createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Long id);
}
