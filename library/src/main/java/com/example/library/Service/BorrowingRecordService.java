package com.example.library.Service;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.library.Entity.BorrowingRecordEntity;

import com.example.library.Repository.BorrowingRecordRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Service
public class BorrowingRecordService {
     
    @PersistenceContext
     EntityManager entityManager;  

     @Autowired
    private BorrowingRecordRepository repo;
    private  BookService bookService;
    private  PatronService patronService;

    @Autowired
    EntityManagerFactory emf;

    public BorrowingRecordEntity borrowBook(Long bookId, Long patronId) {
         var entity = new BorrowingRecordEntity();
         entity.setBook(bookService.getBooKById(bookId));
         entity.setPatron(patronService.getPatronById(patronId));
         entity.setBorrowDate(LocalDate.now());
         return repo.save(entity);
    }

    public BorrowingRecordEntity returnBook(Long bookId, Long patronId) {
       
        String jpql = "SELECT br FROM BorrowingRecord br " +
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
