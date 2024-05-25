package com.collabera.library.service;

import com.collabera.library.model.dto.BorrowedBookDto;
import com.collabera.library.model.dto.BorrowerDto;
import com.collabera.library.model.entity.BorrowedBook;
import com.collabera.library.model.entity.Borrower;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BorrowedBookService {
    public BorrowedBook borrowBook(UUID borrowerId, UUID bookId);
    public BorrowedBook returnBook(UUID borrowerId, UUID bookId);
}
