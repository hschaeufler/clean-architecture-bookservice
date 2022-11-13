package de.hschaeufler.bookshop.bookservice.books.entity;

public interface BookFactory {
    Book create(String author, String title, String isbn);
}
