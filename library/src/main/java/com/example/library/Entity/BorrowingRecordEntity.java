package com.example.library.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BorrowingRecord")
public class BorrowingRecordEntity {
    
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private BookEntity book;
    @ManyToOne
    private PatronEntity patron;
    private LocalDate borrowDate;
    private LocalDate returnDate;
       

    public BorrowingRecordEntity(){}

    public Long getId() {
        return id;
    }
    
    public BookEntity getBook() {
        return book;
    }
    public void setBook(BookEntity book) {
        this.book = book;
    }
    public PatronEntity getPatron() {
        return patron;
    }
    public void setPatron(PatronEntity patron) {
        this.patron = patron;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    
}
