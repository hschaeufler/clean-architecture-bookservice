package de.hschaeufler.bookshop.bookservice.policy;

public class BookEntity implements Book {

    private final String title;
    private final String author;
    private final String isbn;

    protected BookEntity(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
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
