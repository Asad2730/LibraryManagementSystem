package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.library.entity.BorrowingRecordEntity;



public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecordEntity, Long> {
}