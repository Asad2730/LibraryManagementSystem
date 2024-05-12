package com.example.library.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "borrowRecords")
public class BorrowingRecordEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "book")
    @ManyToOne
    private BookEntity book;
    
    @Column(name="patron")
    @ManyToOne
    private PatronEntity patron;

    @Column(name="localDate")
    private LocalDate borrowDate;

    @Column(name = "returnDate")
    private LocalDate returnDate;

   
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

    public void setId(Long id) {
        this.id = id;
    }
    
}
