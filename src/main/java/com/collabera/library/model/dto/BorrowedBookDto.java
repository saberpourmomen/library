package com.collabera.library.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowedBookDto {
    private UUID id;
    @NotBlank(message = "bookId is mandatory")
    private UUID bookId;
    @NotBlank(message = "borrowerId is mandatory")
    private UUID borrowerId;
    @NotBlank(message = "borrowedDate is mandatory")
    private Timestamp borrowedDate;
    @NotBlank(message = "returnedDate is mandatory")
    private Timestamp returnedDate;
}
