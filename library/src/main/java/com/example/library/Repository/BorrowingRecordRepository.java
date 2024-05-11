package com.example.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.Entity.BorrowingRecordEntity;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecordEntity, Long> {
}