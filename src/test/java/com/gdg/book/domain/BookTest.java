package com.gdg.book.domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookCreationWithNoArgsConstructor() {
        Book book = new Book();
        assertNotNull(book);
    }

    @Test
    void testBookCreationWithAllArgsConstructor() {
        Author author1 = new Author("1", "John Doe", "john@example.com", "Author bio");
        Author author2 = new Author("2", "Jane Smith", "jane@example.com", "Another bio");
        List<Author> authors = Arrays.asList(author1, author2);
        
        Book book = new Book("book1", "Test Book", "A test book description", 2023, authors);
        
        assertEquals("book1", book.getId());
        assertEquals("Test Book", book.getName());
        assertEquals("A test book description", book.getDescription());
        assertEquals(Integer.valueOf(2023), book.getYearPublication());
        assertEquals(2, book.getAuthors().size());
        assertEquals("John Doe", book.getAuthors().get(0).getName());
    }

    @Test
    void testBookSettersAndGetters() {
        Book book = new Book();
        Author author = new Author("1", "Test Author", "test@example.com", "Test bio");
        List<Author> authors = Arrays.asList(author);
        
        book.setId("test-id");
        book.setName("Test Book Name");
        book.setDescription("Test Description");
        book.setYearPublication(2024);
        book.setAuthors(authors);
        
        assertEquals("test-id", book.getId());
        assertEquals("Test Book Name", book.getName());
        assertEquals("Test Description", book.getDescription());
        assertEquals(Integer.valueOf(2024), book.getYearPublication());
        assertEquals(1, book.getAuthors().size());
        assertEquals("Test Author", book.getAuthors().get(0).getName());
    }

    @Test
    void testBookToString() {
        Author author = new Author("1", "Test Author", "test@example.com", "Test bio");
        List<Author> authors = Arrays.asList(author);
        Book book = new Book("1", "Test Book", "Description", 2023, authors);
        
        String toString = book.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("Book"));
        assertTrue(toString.contains("Test Book"));
        assertTrue(toString.contains("2023"));
    }
}