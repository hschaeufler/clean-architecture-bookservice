package de.hschaeufler.bookshop.bookservice.details.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BookModel {
    @Id
    private String isbn;
    private String title;
    private String author;
}
