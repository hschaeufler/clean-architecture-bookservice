package de.hschaeufler.bookshop.bookservice.policy.registerbook.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterBookResponseModel {
    final String title;
    final String author;
    final String isbn;
}
