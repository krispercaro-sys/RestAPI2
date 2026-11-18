
package com.spring.spring_rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.service.StudentService;

import jakarta.validation.Valid;

/**
 * REST controller for managing student records.
 * Provides endpoints for CRUD operations on students.
 */
@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private StudentService studentService;

    /**
     * Constructs the controller with the required student service.
     *
     * @param studentService the service for managing students
     */
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Creates a new student.
     *
     * @param theStudentDto the student data to create
     * @return the created student with HTTP 201 CREATED
     */
    @PostMapping
    public ResponseEntity<StudentDto> createStudents(
            @Valid @RequestBody StudentDto theStudentDto) {

        StudentDto saved =
                studentService.createStudent(theStudentDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * Retrieves a student by their ID.
     *
     * @param id the ID of the student
     * @return the student with HTTP 200 OK
     */
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(
            @PathVariable Long id) {

        StudentDto studentDto = studentService.getStudentById(id);

        return ResponseEntity.ok(studentDto);
    }

    /**
     * Retrieves all students.
     *
     * @return a list of students with HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent() {

        List<StudentDto> students = studentService.getAllStudents();

        return ResponseEntity.ok(students);
    }

    /**
     * Updates an existing student's information.
     *
     * @param id the ID of the student to update
     * @param theStudentDto the updated student data
     * @return the updated student with HTTP 200 OK
     */
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDto theStudentDto) {

        StudentDto studentDto =
                studentService.updateStudent(id, theStudentDto);

        return ResponseEntity.ok(studentDto);
    }

    /**
     * Partially updates an existing student's information.
     *
     * @param id the ID of the student to update
     * @param theStudentDto the student fields to update
     * @return the updated student with HTTP 200 OK
     */
    @PatchMapping("{id}")
    public ResponseEntity<StudentDto> patchStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDto theStudentDto) {

        StudentDto studentDto =
                studentService.patchStudent(id, theStudentDto);

        return ResponseEntity.ok(studentDto);
    }

    /**
     * Deletes a student by their ID.
     *
     * @param id the ID of the student to delete
     * @return a success message with HTTP 200 OK
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentById(
            @PathVariable Long id) {

        studentService.deleteStudentById(id);

        return ResponseEntity.ok("Student deleted successfully!");
    }
}
