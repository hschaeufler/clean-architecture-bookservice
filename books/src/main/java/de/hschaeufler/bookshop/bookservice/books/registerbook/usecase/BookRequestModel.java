package de.hschaeufler.bookshop.bookservice.books.registerbook.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookRequestModel {
    final String title;
    final String author;
    final String isbn;
}
