package com.example.library.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.library.entity.BookEntity;
import com.example.library.errorHandling.ResourceNotFoundException;
import com.example.library.repository.BookRepository;

@Service
public class BookService {
    
    
    private  BookRepository repo;
     
    
     BookService(BookRepository repo){
        this.repo = repo;
     }
   
    public List<BookEntity> getAllBooks(){
        return repo.findAll();
    }

    public BookEntity getBooKById(Long id){
        return repo.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Book", "id", id));
    }


    public BookEntity createBook(BookEntity entity){
       
        return repo.save(entity);
    }

    public BookEntity updateBook(Long id,BookEntity entity){
          
        return repo.findById(id)
               .map(book -> {
                  book.setAuthor(entity.getAuthor());
                  book.setIsbn(entity.getIsbn());
                  book.setPublicationYear(entity.getPublicationYear());
                  book.setTitle(entity.getTitle());
                  return repo.save(book);
               })
               .orElseThrow(()-> new ResourceNotFoundException("Book", "id", id));
    }

    public void deleteBook(Long id){
        repo.deleteById(id);
    }
}
