package com.example.library.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Entity.BookEntity;
import com.example.library.Entity.BorrowingRecordEntity;
import com.example.library.Entity.PatronEntity;
import com.example.library.Repository.BorrowingRecordRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;


@Service
public class BorrowingRecordService {
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


    public BorrowingRecordEntity returnBook(Long bookId, Long patronId){
       
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("");
        
        BorrowingRecordEntity rs = query.getClass();
    }


}
