package com.project.student.service.impl;

import com.project.student.dto.StudentDto;
import com.project.student.entity.Student;
import com.project.student.mapper.StudentMapper;
import com.project.student.repository.StudentRepository;
import com.project.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;;
    @Override
    public List<StudentDto> listOfStudents() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(
                        StudentMapper::mapToStudentDto
                ).collect(Collectors.toList());
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
