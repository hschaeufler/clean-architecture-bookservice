package de.hschaeufler.bookshop.bookservice.books;

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