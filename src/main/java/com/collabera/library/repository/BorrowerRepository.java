package com.collabera.library.repository;

import com.collabera.library.model.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, UUID> {
    Optional<Borrower> findByEmail(String email);
}
