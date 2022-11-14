package de.hschaeufler.bookshop.bookservice.data.datasource;

import de.hschaeufler.bookshop.bookservice.data.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface BookDAO extends JpaRepository<BookModel,String> {
}
