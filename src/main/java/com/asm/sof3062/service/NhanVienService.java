package com.asm.sof3062.service;

/**
 * <h1>NhanVienService</h1>
 * <p>
 * This is the "Manager" of our employee operations.
 * </p>
 * <p>
 * <b>Why do we need this?</b><br>
 * The Controller (the waiter) shouldn't know how to cook the food (fetch data).
 * It should just take the order and give it to the Manager (Service).
 * This interface defines what the Manager can do, like "get employee details"
 * or "delete an employee".
 * </p>
 */
public interface NhanVienService {

    /**
     * Gets the details of a specific employee.
     *
     * @param id The unique ID of the employee.
     * @return The employee's information.
     */
    Object getEmployeeById(String id);

    /**
     * Deletes an employee from the system.
     *
     * @param id The unique ID of the employee to delete.
     */
    void deleteEmployee(String id);
}
