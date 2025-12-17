package com.asm.sof3062.controller;

import com.asm.sof3062.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <h1>NhanVienController</h1>
 * <p>
 * This is the "Waiter" of our restaurant (application).
 * </p>
 * <p>
 * <b>Why do we need this?</b><br>
 * When the website (frontend) asks for something, it talks to this Controller.
 * The Controller takes the request and passes it to the Service (the
 * kitchen/manager)
 * to get the work done, then brings the result back to the website.
 * </p>
 */
@RestController
@RequestMapping("/api/nhanvien")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienService nhanVienService;

    @Value("${FIREBASE_DATABASE_URL}")
    private String firebaseUrl;

    /**
     * Provides the Firebase URL to the frontend.
     * <p>
     * The frontend needs to know where the database is to save data directly.
     * This method hands over that address.
     * </p>
     *
     * @return A map containing the Firebase URL.
     */
    @GetMapping("/config")
    public ResponseEntity<Map<String, String>> getConfig() {
        return ResponseEntity.ok(Map.of("url", firebaseUrl));
    }

    /**
     * Handles the request to get employee details for editing.
     *
     * @param id The ID of the employee to edit.
     * @return The employee data.
     */
    @GetMapping("/edit/{id}")
    public ResponseEntity<Object> edit(@PathVariable String id) {
        Object result = nhanVienService.getEmployeeById(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Handles the request to delete an employee.
     *
     * @param id The ID of the employee to delete.
     * @return An empty response indicating success.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        nhanVienService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
