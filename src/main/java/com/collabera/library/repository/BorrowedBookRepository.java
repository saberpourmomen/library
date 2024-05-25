package com.collabera.library.repository;

import com.collabera.library.model.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, UUID> {
    Optional<BorrowedBook> findByBookIdAndReturnedDateIsNull(UUID bookId);
}
