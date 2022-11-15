package de.hschaeufler.bookshop.bookservice.policy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookEntityTest {

    final String givenAuthor = "Uncle Bob";
    final String givenTitle = "Clean Architecture";
    final String givenIsbn = "122334";

    @Test
    @DisplayName("GIVEN values WHEN BookEntity is instantiated THEN should be a instance of Book")
    void givenValues_whenBookEntityIsInstantiated_shouldBeInstanceOfBook() {
        // given

        // when
        final BookEntity actualBookEntity = new BookEntity(
                givenTitle, givenAuthor, givenIsbn
        );
        // then
        assertTrue(actualBookEntity instanceof Book);
    }

    @Test
    @DisplayName("GIVEN BookEntity with given Author WHEN getAuthor is called THEN it should return givenAutor")
    void givenBookEntityWithAuthor_whenGetAuthorIsCalled_thenShouldReturnGivenAuthor() {
        // given
        final BookEntity givenBookEntity = new BookEntity(
                givenTitle, givenAuthor, givenIsbn
        );

        // when
        final String actualAuthor = givenBookEntity.getAuthor();

        // then
        assertEquals(givenAuthor, actualAuthor);
    }

    @Test
    @DisplayName("GIVEN BookEntity with given Title WHEN getTitle is called THEN it should return givenTitle")
    void givenBookEntityWithTitle_whenGetAuthorIsCalled_thenShouldReturnGivenTitle() {
        // given
        final BookEntity givenBookEntity = new BookEntity(
                givenTitle, givenAuthor, givenIsbn
        );

        // when
        final String actualTitle = givenBookEntity.getTitle();

        // then
        assertEquals(givenTitle, actualTitle);
    }

    @Test
    @DisplayName("GIVEN BookEntity with given ISBN WHEN getISBN is called THEN it should return givenISBN")
    void givenBookEntityWithISBN_whenGetAuthorIsCalled_thenShouldReturnGivenISBN() {
        // given
        final BookEntity givenBookEntity = new BookEntity(
                givenTitle, givenAuthor, givenIsbn
        );

        // when
        final String actualISBN = givenBookEntity.getISBN();

        // then
        assertEquals(givenIsbn, actualISBN);
    }
}
