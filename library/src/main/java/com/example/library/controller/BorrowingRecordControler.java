package com.example.library.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.service.BorrowingRecordService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/borrow")
public class BorrowingRecordControler {

    
    private BorrowingRecordService db;

    @PostMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<?> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        try {
            var response = db.borrowBook(bookId, patronId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Exception: " + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<?> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        try {
            var response = db.returnBook(bookId, patronId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Exception: " + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
