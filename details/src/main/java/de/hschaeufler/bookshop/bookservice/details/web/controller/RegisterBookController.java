package de.hschaeufler.bookshop.bookservice.details.web.controller;

import de.hschaeufler.bookshop.bookservice.details.web.model.RegisterBookRequestDTO;
import de.hschaeufler.bookshop.bookservice.details.web.model.RegisterBookResponseDTO;

public interface RegisterBookController {
    RegisterBookResponseDTO registerBook(RegisterBookRequestDTO registerBookRequestDTO);
}
