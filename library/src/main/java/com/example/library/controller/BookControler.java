package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.BookEntity;
import com.example.library.service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/books")
public class BookControler {
    
    @Autowired
    private  BookService db ;
    

    @GetMapping("/")
    public ResponseEntity<?> getAllBooks() {
        try{
         
           var response =  db.getAllBooks();
           return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception ex){
              return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        try{
            var response =  db.getBooKById(id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception ex){
              return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    
   
    
    @PostMapping("/")
    public ResponseEntity<?> createBook(@RequestBody BookEntity entity) {
        try{ 
           var response = db.createBook(entity);
           return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception ex){
              return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookEntity entity) {
        try{
            var response = db.updateBook(id,entity);
           return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception ex){
              return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        try{
           db.deleteBook(id);
           return new ResponseEntity<>("Deleted book with id:"+id,HttpStatus.OK);
        }catch(Exception ex){
              return new ResponseEntity<>("Exception:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

}
