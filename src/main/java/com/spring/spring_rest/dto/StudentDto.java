
package com.spring.spring_rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object for student information.
 * Contains student details and validation constraints.
 */
public class StudentDto {

    /** Unique identifier of the student. */
    private Long id;

    /** First name must contain 2 to 50 characters. */
    @Size(min = 2, max = 50,
            message = "Must be 2 to 50 characters.")
    private String firstName;

    /** Last name must contain 2 to 50 characters. */
    @Size(min = 2, max = 50,
            message = "Must be 2 to 50 characters.")
    private String lastName;

    /** Email must not be empty and must have a valid format. */
    @NotEmpty(message = "Email is required and should be valid")
    @Email(message = "Email is required and should be valid")
    private String email;

    /**
     * Default constructor.
     */
    public StudentDto() {
    }

    /**
     * Constructs a StudentDto with the provided student details.
     *
     * @param id the student's unique identifier
     * @param firstName the student's first name
     * @param lastName the student's last name
     * @param email the student's email address
     */
    public StudentDto(
            Long id,
            String firstName,
            String lastName,
            String email) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets the student's ID.
     *
     * @return the student's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the student's ID.
     *
     * @param id the student's ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the student's first name.
     *
     * @return the student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     *
     * @param firstName the student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the student's last name.
     *
     * @return the student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName the student's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the student's email address.
     *
     * @return the student's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email address.
     *
     * @param email the student's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
