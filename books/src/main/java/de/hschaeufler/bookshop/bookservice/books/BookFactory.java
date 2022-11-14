package de.hschaeufler.bookshop.bookservice.books;

public interface BookFactory {
    Book create(String title, String author, String isbn);
}
