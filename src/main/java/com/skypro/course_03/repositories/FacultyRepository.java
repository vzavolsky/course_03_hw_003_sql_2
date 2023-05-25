package com.skypro.course_03.repositories;

import com.skypro.course_03.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    public Collection<Faculty> findAllByColor(String color);
}
