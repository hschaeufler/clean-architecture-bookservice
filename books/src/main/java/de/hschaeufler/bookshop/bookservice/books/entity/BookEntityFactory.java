package de.hschaeufler.bookshop.bookservice.books.entity;

public class BookEntityFactory implements BookFactory {

    @Override
    public Book create(
            final String author,
            final String title,
            final String isbn
    ) {
        return new BookEntity(author, title, isbn);
    }
}