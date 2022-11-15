package de.hschaeufler.bookshop.bookservice.details.data.datasource;

import de.hschaeufler.bookshop.bookservice.details.data.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface BookDAO extends JpaRepository<BookModel, String> {
}
