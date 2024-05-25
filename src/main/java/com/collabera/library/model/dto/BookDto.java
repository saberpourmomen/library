package com.collabera.library.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    @NotBlank(message = "ISBN is mandatory")
    @Size(min = 10, max = 13, message = "ISBN should be between 10 and 13 characters")
    private String isbn;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;
}
