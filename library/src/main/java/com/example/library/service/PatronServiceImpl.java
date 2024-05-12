package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entity.PatronEntity;
import com.example.library.errorHandling.ResourceNotFoundException;
import com.example.library.repository.PatronRepository;

@Service
public class PatronServiceImpl implements PatronService {
    
    @Autowired
    private PatronRepository repo;
    
    @Override
    public List<PatronEntity> getAllPatron() {
        return repo.findAll();
    } 
   
    @Override
    public PatronEntity getPatronById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patron", "id", id));
    }
    
    @Override
    public PatronEntity createPatron(PatronEntity entity) {
        return repo.save(entity);
    }
    
    @Override
    public PatronEntity updatePatron(Long id, PatronEntity entity) {

        return repo.findById(id)
                .map(patron -> {
                    patron.setName(entity.getName());
                    patron.setContactInformation(entity.getContactInformation());
                    return repo.save(patron);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Patron", "id", id));
    }
   
    @Override
    public void deletePatron(Long id) {
        repo.deleteById(id);
    }
}
