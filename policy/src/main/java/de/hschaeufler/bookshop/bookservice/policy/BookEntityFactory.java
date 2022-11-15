package de.hschaeufler.bookshop.bookservice.policy;

public class BookEntityFactory implements BookFactory {

    @Override
    public Book create(
            final String title,
            final String author,
            final String isbn
    ) {
        return new BookEntity(title, author, isbn);
    }
}