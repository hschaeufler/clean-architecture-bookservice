package de.hschaeufler.bookshop.bookservice.domain.registerbook.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BookResponseModel {
    final String title;
    final String author;
    final String isbn;
}