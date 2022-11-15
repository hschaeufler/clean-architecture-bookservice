package de.hschaeufler.bookshop.bookservice.policy.getbooks.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetBooksResponseModel {
    final String title;
    final String author;
    final String isbn;
    final int bookNumber;
}
