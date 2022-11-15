package de.hschaeufler.bookshop.bookservice.details.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetBooksResponseDTO {
    final String title;
    final String author;
    final String isbn;
    final int bookNumber;
}
