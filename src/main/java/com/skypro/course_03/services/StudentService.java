package com.skypro.course_03.services;

import com.skypro.course_03.entity.Student;
import com.skypro.course_03.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Optional<Student> update(Long id, Student student) {
        return studentRepository.findById(id)
                .map(s -> {
                    s.setName(student.getName());
                    s.setAge(student.getAge());
                    return studentRepository.save(s);
                });
    }

    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    public Collection<Student> getAll() {
        return Collections.unmodifiableCollection(studentRepository.findAll());
    }

    public Optional<Student> deleteById(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.deleteById(id);
                    return student;
                });
    }

    public Collection<Student> getStudentsByAge(int age) {
        return studentRepository.getStudentsByAge(age);
    }
}
