package com.asm.sof3062.controller;

import com.asm.sof3062.service.SinhVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <h1>SinhVienController</h1>
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
@RequestMapping("/api/sinhvien")
@RequiredArgsConstructor
public class SinhVienController {

    private final SinhVienService sinhVienService;

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
     * Handles the request to get student details for editing.
     *
     * @param id The ID of the student to edit.
     * @return The student data.
     */
    @GetMapping("/edit/{id}")
    public ResponseEntity<Object> edit(@PathVariable String id) {
        Object result = sinhVienService.getStudentById(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Handles the request to delete a student.
     *
     * @param id The ID of the student to delete.
     * @return An empty response indicating success.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        sinhVienService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
