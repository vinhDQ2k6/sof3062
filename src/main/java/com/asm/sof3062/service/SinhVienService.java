package com.asm.sof3062.service;

/**
 * <h1>SinhVienService</h1>
 * <p>
 * This is the "Manager" of our student operations.
 * </p>
 * <p>
 * <b>Why do we need this?</b><br>
 * The Controller (the waiter) shouldn't know how to cook the food (fetch data).
 * It should just take the order and give it to the Manager (Service).
 * This interface defines what the Manager can do, like "get student details" or
 * "delete a student".
 * </p>
 */
public interface SinhVienService {

    /**
     * Gets the details of a specific student.
     *
     * @param id The unique ID of the student.
     * @return The student's information.
     */
    Object getStudentById(String id);

    /**
     * Deletes a student from the system.
     *
     * @param id The unique ID of the student to delete.
     */
    void deleteStudent(String id);
}
