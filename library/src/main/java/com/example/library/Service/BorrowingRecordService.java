package com.example.library.service;

import com.example.library.entity.BorrowingRecordEntity;

public interface BorrowingRecordService {
     BorrowingRecordEntity borrowBook(Long bookId, Long patronId);
     BorrowingRecordEntity returnBook(Long bookId, Long patronId);
}
