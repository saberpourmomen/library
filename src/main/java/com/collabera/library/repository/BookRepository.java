package com.collabera.library.repository;

import com.collabera.library.model.entity.Book;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

}
