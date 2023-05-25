package com.skypro.course_03.controllers;

import com.skypro.course_03.entity.Faculty;
import com.skypro.course_03.services.FacultyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/faculty")
@Tag(name = "Faculty UI", description = "Check your faculty methods.")
public class FacultyController {

    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAll() {
        return ResponseEntity.ok(facultyService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Faculty>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Faculty> add(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.add(faculty));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Optional<Faculty>> update(@PathVariable Long id, @RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(id, faculty));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Optional<Faculty>> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.deleteById(id));
    }
}
