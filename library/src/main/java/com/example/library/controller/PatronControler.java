package com.example.library.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.PatronEntity;
import com.example.library.service.PatronService;

@RestController
@RequestMapping("/api/patrons")
public class PatronControler {

    
    private  PatronService db ;

       @GetMapping("/")
    public ResponseEntity<?> getAllPatrons() {
        try{
            var response = db.getAllPatron();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatronById(@PathVariable Long id) {
        try{
            var response = db.getPatronById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createPatron(@RequestBody PatronEntity entity) {
        try{
            var response = db.createPatron(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatron(@PathVariable Long id, @RequestBody PatronEntity entity) {
        try{
            var response = db.updatePatron(id, entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatron(@PathVariable Long id) {
        try{
            db.deletePatron(id);
            return new ResponseEntity<>("Deleted patron with id:"+id, HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

}
