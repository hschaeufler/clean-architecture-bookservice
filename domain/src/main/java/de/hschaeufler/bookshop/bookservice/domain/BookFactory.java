package de.hschaeufler.bookshop.bookservice.domain;

public interface BookFactory {
    Book create(String title, String author, String isbn);
}
