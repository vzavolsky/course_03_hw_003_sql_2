package com.skypro.course_03.repositories;

import com.skypro.course_03.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> getStudentsByAge(int age);
}
