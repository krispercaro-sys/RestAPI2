
package com.spring.spring_rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;

/**
 * Implementation of StudentService for managing student records.
 * Handles student CRUD operations using StudentRepository.
 */
@Service
public class StudentServiceImplement implements StudentService {

    private final StudentRepository studentRepo;

    /**
     * Constructs the service with the required repository.
     *
     * @param studentRepo the repository for accessing student records
     */
    public StudentServiceImplement(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    /**
     * Creates and saves a new student.
     *
     * @param theStudentDto the student data to create
     * @return the saved student details
     */
    @Override
    public StudentDto createStudent(StudentDto theStudentDto) {

        Student theStudent =
                StudentMapper.mapToStudent(theStudentDto);

        Student saved = studentRepo.save(theStudent);

        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Retrieves a student by their ID.
     *
     * @param theId the ID of the student to retrieve
     * @return the student details
     * @throws StudentNotFoundException if the student does not exist
     */
    @Override
    public StudentDto getStudentById(Long theId) {

        Student student = studentRepo.findById(theId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student id " + theId + " not found!"));

        return StudentMapper.mapToStudentDto(student);
    }

    /**
     * Retrieves all students from the database.
     *
     * @return a list of all student details
     */
    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepo.findAll();

        return students.stream()
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    /**
     * Updates all student information for an existing student.
     *
     * @param theId the ID of the student to update
     * @param theStudentDto the updated student data
     * @return the updated student details
     * @throws StudentNotFoundException if the student does not exist
     */
    @Override
    public StudentDto updateStudent(
            Long theId, StudentDto theStudentDto) {

        Student student = studentRepo.findById(theId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student id " + theId + " not found!"));

        student.setFirstName(theStudentDto.getFirstName());
        student.setLastName(theStudentDto.getLastName());
        student.setEmail(theStudentDto.getEmail());

        Student saved = studentRepo.save(student);

        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Partially updates an existing student's information.
     * Only fields that are not null will be updated.
     *
     * @param theId the ID of the student to update
     * @param theStudentDto the student fields to update
     * @return the updated student details
     * @throws StudentNotFoundException if the student does not exist
     */
    @Override
    public StudentDto patchStudent(
            Long theId, StudentDto theStudentDto) {

        Student student = studentRepo.findById(theId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student id " + theId + " not found!"));

        if (theStudentDto.getFirstName() != null) {
            student.setFirstName(theStudentDto.getFirstName());
        }

        if (theStudentDto.getLastName() != null) {
            student.setLastName(theStudentDto.getLastName());
        }

        if (theStudentDto.getEmail() != null) {
            student.setEmail(theStudentDto.getEmail());
        }

        Student saved = studentRepo.save(student);

        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Deletes an existing student by their ID.
     *
     * @param theId the ID of the student to delete
     * @throws StudentNotFoundException if the student does not exist
     */
    @Override
    public void deleteStudentById(Long theId) {

        studentRepo.findById(theId)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student id " + theId + " not found!"));

        studentRepo.deleteById(theId);
    }
}
