package com.collabera.library.service;

import com.collabera.library.model.dto.BookDto;
import com.collabera.library.model.entity.Book;
import com.collabera.library.model.entity.BorrowedBook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BookService {
    Book getBookById(UUID bookId);
    public Book registerBook(BookDto bookDto);
    public List<Book> getAllBooks();
}
