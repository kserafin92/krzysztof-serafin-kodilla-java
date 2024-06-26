package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        // Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Author1", "Title1", 2001, "Signature1"));
        bookSet.add(new Book("Author2", "Title2", 1999, "Signature2"));
        bookSet.add(new Book("Author3", "Title3", 2010, "Signature3"));
        bookSet.add(new Book("Author4", "Title4", 2015, "Signature4"));
        bookSet.add(new Book("Author5", "Title5", 2020, "Signature5"));

        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int medianYear = medianAdapter.publicationYearMedian(bookSet);

        // Then
        assertEquals(2010, medianYear);
    }
}
