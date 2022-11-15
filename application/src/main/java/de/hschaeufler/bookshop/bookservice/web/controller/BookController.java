package de.hschaeufler.bookshop.bookservice.web.controller;

import de.hschaeufler.bookshop.bookservice.domain.getbooks.usecase.BookResponseModel;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.usecase.GetBooks;
import de.hschaeufler.bookshop.bookservice.domain.getbooks.usecase.NoBooksFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    final GetBooks getBooks;

    @GetMapping("/books")
    List<BookResponseModel> getBooks() {
        try {
            return getBooks.getBooks();
        } catch (NoBooksFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Books Found!", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "I'm a Teapot!", e);
        }

    }

}
