package com.example.library.service;

import java.util.List;

import com.example.library.entity.BookEntity;

public interface BookService {
    List<BookEntity> getAllBooks();
    BookEntity getBooKById(Long id);
    BookEntity createBook(BookEntity entity);
    BookEntity updateBook(Long id,BookEntity entity);
    void deleteBook(Long id);
}
