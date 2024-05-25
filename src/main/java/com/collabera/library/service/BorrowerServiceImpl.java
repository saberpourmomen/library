package com.collabera.library.service;

import com.collabera.library.exception.ResourceNotFoundException;
import com.collabera.library.model.dto.BorrowedBookDto;
import com.collabera.library.model.dto.BorrowerDto;
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
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    public Borrower registerBorrower(BorrowerDto borrowerDto) {
        Borrower borrower = new Borrower();
        borrower.setName(borrowerDto.getName());
        borrower.setEmail(borrowerDto.getEmail());
        return borrowerRepository.save(borrower);
    }

    public Borrower getBorrower(UUID id) {
        return borrowerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found"));
    }
}
