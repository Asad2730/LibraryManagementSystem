package com.example.library.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.library.Entity.PatronEntity;
import com.example.library.ErrorHandling.ResourceNotFoundException;
import com.example.library.Repository.PatronRepository;

@Service
public class PatronService {
    
    @Autowired
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
