package de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterBookRequestModel {
    final String title;
    final String author;
    final String isbn;
}
