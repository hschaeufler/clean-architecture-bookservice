package de.hschaeufler.bookshop.bookservice.policy;

public interface BookFactory {
    Book create(String title, String author, String isbn);
}
