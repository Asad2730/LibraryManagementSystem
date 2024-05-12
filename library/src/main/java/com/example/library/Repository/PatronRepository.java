package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.library.entity.PatronEntity;



public interface PatronRepository extends JpaRepository<PatronEntity, Long> {
}