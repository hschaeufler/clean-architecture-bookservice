package de.hschaeufler.bookshop.bookservice.details.web.controller;

import de.hschaeufler.bookshop.bookservice.details.web.model.GetBooksResponseDTO;

import java.util.List;

public interface GetBooksController {
    List<GetBooksResponseDTO> getBooks();
}
