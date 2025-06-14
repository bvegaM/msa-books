package com.gdg.book.service.impl;

import com.gdg.book.domain.Author;
import com.gdg.book.domain.Book;
import com.gdg.book.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testSaveBook() {
        // Given
        Author author = new Author("1", "John Doe", "john@example.com", "Author bio");
        List<Author> authors = Arrays.asList(author);
        Book book = new Book("book1", "Test Book", "A test book description", 2023, authors);
        
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // When
        Book savedBook = bookService.save(book);

        // Then
        assertNotNull(savedBook);
        assertEquals("book1", savedBook.getId());
        assertEquals("Test Book", savedBook.getName());
        assertEquals("A test book description", savedBook.getDescription());
        assertEquals(Integer.valueOf(2023), savedBook.getYearPublication());
        assertEquals(1, savedBook.getAuthors().size());
        assertEquals("John Doe", savedBook.getAuthors().get(0).getName());
    }

    @Test
    void testFindByIdExists() {
        // Given
        Author author = new Author("1", "John Doe", "john@example.com", "Author bio");
        List<Author> authors = Arrays.asList(author);
        Book book = new Book("book1", "Test Book", "A test book description", 2023, authors);
        
        when(bookRepository.findById("book1")).thenReturn(Optional.of(book));

        // When
        Book foundBook = bookService.findById("book1");

        // Then
        assertNotNull(foundBook);
        assertEquals("book1", foundBook.getId());
        assertEquals("Test Book", foundBook.getName());
    }

    @Test
    void testFindByIdNotExists() {
        // Given
        when(bookRepository.findById("nonexistent")).thenReturn(Optional.empty());

        // When
        Book foundBook = bookService.findById("nonexistent");

        // Then
        assertNull(foundBook);
    }
}