package com.asm.sof3062.service.impl;

import com.asm.sof3062.service.SinhVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>SinhVienServiceImpl</h1>
 * <p>
 * This is the actual worker who does the job defined by the Manager
 * (SinhVienService).
 * </p>
 * <p>
 * <b>Why do we need this?</b><br>
 * We need someone to actually go to Firebase and get the data. This class uses
 * the RestTemplate (the messenger) to talk to the database.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class SinhVienServiceImpl implements SinhVienService {

    private final RestTemplate restTemplate;

    @Value("${FIREBASE_DATABASE_URL}")
    private String firebaseUrl;

    /**
     * {@inheritDoc}
     * <p>
     * It builds the specific URL for the student (like finding their home address)
     * and sends the messenger to get the info.
     * </p>
     */
    @Override
    public Object getStudentById(String id) {
        String url = firebaseUrl + "/sinhVien/" + id + ".json";
        return restTemplate.getForObject(url, Object.class);
    }

    /**
     * {@inheritDoc}
     * <p>
     * It builds the URL and tells the messenger to remove the data at that address.
     * </p>
     */
    @Override
    public void deleteStudent(String id) {
        String url = firebaseUrl + "/sinhVien/" + id + ".json";
        restTemplate.delete(url);
    }
}
