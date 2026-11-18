
package com.spring.spring_rest.service;

import java.util.List;

import com.spring.spring_rest.dto.StudentDto;

/**
 * Service interface for managing student records.
 * Defines operations for student CRUD functionality.
 */
public interface StudentService {

    /**
     * Creates a new student.
     *
     * @param theStudentDto the student data to create
     * @return the created student details
     */
    StudentDto createStudent(StudentDto theStudentDto);

    /**
     * Retrieves a student by their ID.
     *
     * @param theId the student's ID
     * @return the student details
     */
    StudentDto getStudentById(Long theId);

    /**
     * Retrieves all students.
     *
     * @return a list of all student details
     */
    List<StudentDto> getAllStudents();

    /**
     * Updates an existing student's information.
     *
     * @param theId the ID of the student to update
     * @param thStudentDto the updated student data
     * @return the updated student details
     */
    StudentDto updateStudent(Long theId, StudentDto thStudentDto);

    /**
     * Partially updates an existing student's information.
     *
     * @param theId the ID of the student to update
     * @param thStudentDto the student fields to update
     * @return the updated student details
     */
    StudentDto patchStudent(Long theId, StudentDto thStudentDto);

    /**
     * Deletes a student by their ID.
     *
     * @param theId the ID of the student to delete
     */
    void deleteStudentById(Long theId);
}
