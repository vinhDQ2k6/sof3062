package com.asm.sof3062.service.impl;

import com.asm.sof3062.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>NhanVienServiceImpl</h1>
 * <p>
 * This is the actual worker who does the job defined by the Manager
 * (NhanVienService).
 * </p>
 * <p>
 * <b>Why do we need this?</b><br>
 * We need someone to actually go to Firebase and get the data. This class uses
 * the RestTemplate (the messenger) to talk to the database.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    private final RestTemplate restTemplate;

    @Value("${FIREBASE_DATABASE_URL}")
    private String firebaseUrl;

    /**
     * {@inheritDoc}
     * <p>
     * It builds the specific URL for the employee (like finding their home address)
     * and sends the messenger to get the info.
     * </p>
     */
    @Override
    public Object getEmployeeById(String id) {
        String url = firebaseUrl + "/nhanVien/" + id + ".json";
        return restTemplate.getForObject(url, Object.class);
    }

    /**
     * {@inheritDoc}
     * <p>
     * It builds the URL and tells the messenger to remove the data at that address.
     * </p>
     */
    @Override
    public void deleteEmployee(String id) {
        String url = firebaseUrl + "/nhanVien/" + id + ".json";
        restTemplate.delete(url);
    }
}
