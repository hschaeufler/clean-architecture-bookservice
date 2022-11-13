package de.hschaeufler.bookshop.bookservice.books.entity;

public class BookEntity implements Book {

    private final String author;
    private final String title;
    private final String isbn;

    protected BookEntity(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }


    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getISBN() {
        return isbn;
    }
}
