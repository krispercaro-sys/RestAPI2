
package com.spring.spring_rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity representing a student in the database.
 * Maps student information to the student table.
 */
@Entity
@Table(name = "student")
public class Student {

    /** Unique identifier generated automatically by the database. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Student's first name. Cannot be null in the database. */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /** Student's last name. Cannot be null in the database. */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /** Student's email. Must be unique and cannot be null. */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * Default constructor required by JPA.
     */
    public Student() {
    }

    /**
     * Constructs a Student with the provided information.
     *
     * @param id the student's unique identifier
     * @param firstName the student's first name
     * @param lastName the student's last name
     * @param email the student's email address
     */
    public Student(
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
