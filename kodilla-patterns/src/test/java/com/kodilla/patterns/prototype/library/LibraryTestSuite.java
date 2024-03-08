package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        // Given
        Library library = new Library("Test Library");

        Book book1 = new Book("Title1", "Author1", LocalDate.of(2000, 1, 1));
        Book book2 = new Book("Title2", "Author2", LocalDate.of(2000, 2, 1));
        Book book3 = new Book("Title3", "Author3", LocalDate.of(2000, 3, 1));

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);



        // When
        Library shallowCopy = null;
        Library deepCopy = null;

        try {
            shallowCopy = library.shallowCopy();
            deepCopy = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);;
        }

        // Then
        assertEquals(3, library.getBooks().size());
        assertEquals(3, shallowCopy.getBooks().size());
        assertEquals(3, deepCopy.getBooks().size());

    }
}
