package com.example.library.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.example.library.entity.PatronEntity;
import com.example.library.errorHandling.ResourceNotFoundException;
import com.example.library.repository.PatronRepository;

@Service
public class PatronService {
    

    private PatronRepository repo;

     
    public List<PatronEntity> getAllPatron(){
        return repo.findAll();
    }

    public PatronEntity getPatronById(Long id){
        return repo.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Patron", "id", id));
    }


    public PatronEntity createPatron(PatronEntity entity){
        return repo.save(entity);
    }

    public PatronEntity updatePatron(Long id,PatronEntity entity){
          
        return repo.findById(id)
               .map(patron -> {
                   patron.setName(entity.getName());
                   patron.setContactInformation(entity.getContactInformation());
                  return repo.save(patron);
               })
               .orElseThrow(()-> new ResourceNotFoundException("Patron", "id", id));
    }

    public void deletePatron(Long id){
        repo.deleteById(id);
    }
}
