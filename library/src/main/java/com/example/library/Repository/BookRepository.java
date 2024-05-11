package com.example.library.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.library.Entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}

