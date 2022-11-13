package de.hschaeufler.bookshop.bookservice.books;

public interface BookFactory {
    Book create(String author, String title, String isbn);
}
