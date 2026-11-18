package com.spring.spring_rest.entity;

/**
 * Represents a standardized error response payload for REST endpoints.
 */
public class StudentErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    /**
     * Default no-argument constructor required for JSON serialization.
     */
    public StudentErrorResponse() {
    }

    /**
     * Constructs a new {@code StudentErrorResponse} with the specified
     * error details.
     *
     * @param status    the HTTP status code
     * @param message   the descriptive error message
     * @param timeStamp the timestamp when the error occurred
     */
    public StudentErrorResponse(
            int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    /**
     * Gets the HTTP status code.
     *
     * @return the HTTP status code
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the HTTP status code.
     *
     * @param status the HTTP status code to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the error message.
     *
     * @return the descriptive error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the error message.
     *
     * @param message the error message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the error timestamp.
     *
     * @return the timestamp in milliseconds
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the error timestamp.
     *
     * @param timeStamp the timestamp in milliseconds to set
     */
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

}