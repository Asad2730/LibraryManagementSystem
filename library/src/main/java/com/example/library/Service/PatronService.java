package com.example.library.service;

import java.util.List;

import com.example.library.entity.PatronEntity;

public interface PatronService {
     List<PatronEntity> getAllPatron();
     PatronEntity getPatronById(Long id);
     PatronEntity createPatron(PatronEntity entity);
     PatronEntity updatePatron(Long id, PatronEntity entity);
     void deletePatron(Long id);
}
