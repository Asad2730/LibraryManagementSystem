package com.example.library.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entity.BorrowingRecordEntity;
import com.example.library.repository.BorrowingRecordRepository;

import jakarta.persistence.EntityManager;


import jakarta.persistence.Query;


@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService{
    
    @Autowired
    private BorrowingRecordRepository repo;
    
    @Autowired
    private  BookService bookService;

    @Autowired
    private  PatronService patronService;

    private EntityManager entityManager;  


  
 
    @Override
    public BorrowingRecordEntity borrowBook(Long bookId, Long patronId) {
         var entity = new BorrowingRecordEntity();
         entity.setBook(bookService.getBooKById(bookId));
         entity.setPatron(patronService.getPatronById(patronId));
         entity.setBorrowDate(LocalDate.now());
         return repo.save(entity);
    }
     @Override
    public BorrowingRecordEntity returnBook(Long bookId, Long patronId) {
       
        String jpql = "SELECT br FROM borrowRecords br " +
                      "WHERE br.book.id = :bookId " +
                      "AND br.patron.id = :patronId " +
                      "AND br.returnDate IS NULL";
        
        Query query = entityManager.createQuery(jpql);
        query.setParameter("bookId", bookId);
        query.setParameter("patronId", patronId);

       
        var borrowingRecord = (BorrowingRecordEntity) query.getSingleResult();

       
        borrowingRecord.setReturnDate(LocalDate.now());

     
        repo.save(borrowingRecord);

        return borrowingRecord;
    }


}
