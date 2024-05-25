package com.collabera.library.controller;

import com.collabera.library.model.dto.BookDto;
import com.collabera.library.model.dto.BorrowerDto;
import com.collabera.library.model.entity.Book;
import com.collabera.library.model.entity.BorrowedBook;
import com.collabera.library.model.entity.Borrower;
import com.collabera.library.service.BookService;
import com.collabera.library.service.BorrowedBookService;
import com.collabera.library.service.BorrowerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class LibraryController {
    @Autowired
    BorrowerService borrowerService;
    @Autowired
    BookService bookService;

    @Autowired
    private BorrowedBookService borrowedBookService;

    @PostMapping("/borrow/{borrowerId}/book/{bookId}")
    public ResponseEntity<BorrowedBook> borrowBook(@PathVariable UUID borrowerId, @PathVariable UUID bookId) {
        BorrowedBook borrowedBook = borrowedBookService.borrowBook(borrowerId, bookId);
        return ResponseEntity.ok(borrowedBook);
    }

    @PostMapping("/borrow/return/{borrowerId}/book/{bookId}")
    public ResponseEntity<BorrowedBook> returnBook(@PathVariable UUID borrowerId, @PathVariable UUID bookId) {
        BorrowedBook returnedBook = borrowedBookService.returnBook(borrowerId, bookId);
        return ResponseEntity.ok(returnedBook);
    }


    @PostMapping("/borrower")
    public ResponseEntity<Borrower> registerBorrower(@Valid @RequestBody BorrowerDto borrowerDto) {
        Borrower borrower = borrowerService.registerBorrower(borrowerDto);
        return ResponseEntity.ok(borrower);
    }

    @GetMapping("/borrower/{id}")
    public ResponseEntity<Borrower> getBorrower(@PathVariable UUID id) {
        Borrower borrower = borrowerService.getBorrower(id);
        return ResponseEntity.ok(borrower);
    }
    @PostMapping("/books")
    public ResponseEntity<Book> registerBook(@Valid @RequestBody BookDto bookDto) {
        Book book = bookService.registerBook(bookDto);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/books/list")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }
}
