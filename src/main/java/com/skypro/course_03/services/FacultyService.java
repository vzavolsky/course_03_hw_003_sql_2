package com.skypro.course_03.services;

import com.skypro.course_03.entity.Faculty;
import com.skypro.course_03.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(Faculty faculty) {
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> update(Long id, Faculty faculty) {
        return facultyRepository.findById(id)
                .map(f -> {
                    f.setName(faculty.getName());
                    f.setColor(faculty.getColor());
                    return facultyRepository.save(f);
                });
    }

    public Optional<Faculty> getById(Long id) {
        return facultyRepository.findById(id);
    }

    public Collection<Faculty> getAll() {
        return Collections.unmodifiableCollection(facultyRepository.findAll());
    }

    public Optional<Faculty> deleteById(Long id) {
        return facultyRepository.findById(id)
                .map(f -> {
                    facultyRepository.deleteById(id);
                    return f;
                });
    }

    public Collection<Faculty> findAllByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }
}
