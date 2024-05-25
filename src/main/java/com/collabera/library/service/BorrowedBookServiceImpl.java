package com.collabera.library.service;

import com.collabera.library.exception.ResourceNotFoundException;
import com.collabera.library.model.dto.BorrowedBookDto;
import com.collabera.library.model.entity.Book;
import com.collabera.library.model.entity.BorrowedBook;
import com.collabera.library.model.entity.Borrower;
import com.collabera.library.repository.BookRepository;
import com.collabera.library.repository.BorrowedBookRepository;
import com.collabera.library.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
public class BorrowedBookServiceImpl implements BorrowedBookService {
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public BorrowedBook borrowBook(UUID borrowerId, UUID bookId) {
        Borrower borrower = borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        borrowedBookRepository.findByBookIdAndReturnedDateIsNull(bookId)
                .ifPresent(borrowedBook -> {
                    throw new IllegalStateException("Book is already borrowed");
                });

        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        borrowedBook.setBorrower(borrower);
        borrowedBook.setBorrowedDate(Timestamp.from(Instant.now()));
        return borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public BorrowedBook returnBook(UUID borrowerId, UUID bookId) {
        BorrowedBook borrowedBook = borrowedBookRepository.findByBookIdAndReturnedDateIsNull(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("No borrowed book found"));

        if (!borrowedBook.getBorrower().getId().equals(borrowerId)) {
            throw new IllegalStateException("Borrower mismatch");
        }

        borrowedBook.setReturnedDate(Timestamp.from(Instant.now()));
        return borrowedBookRepository.save(borrowedBook);
    }
}
