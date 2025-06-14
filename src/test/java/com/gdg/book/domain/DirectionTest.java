package com.gdg.book.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testDirectionCreationWithNoArgsConstructor() {
        Direction direction = new Direction();
        assertNotNull(direction);
    }

    @Test
    void testDirectionCreationWithAllArgsConstructor() {
        Direction direction = new Direction("1", "Test Direction", "Main Street 123", "Second Street 456");
        
        assertEquals("1", direction.getId());
        assertEquals("Test Direction", direction.getName());
        assertEquals("Main Street 123", direction.getMainStreet());
        assertEquals("Second Street 456", direction.getSecondStreet());
    }

    @Test
    void testDirectionSettersAndGetters() {
        Direction direction = new Direction();
        
        direction.setId("test-id");
        direction.setName("Test Direction Name");
        direction.setMainStreet("Test Main Street");
        direction.setSecondStreet("Test Second Street");
        
        assertEquals("test-id", direction.getId());
        assertEquals("Test Direction Name", direction.getName());
        assertEquals("Test Main Street", direction.getMainStreet());
        assertEquals("Test Second Street", direction.getSecondStreet());
    }

    @Test
    void testDirectionToString() {
        Direction direction = new Direction("1", "Test Direction", "Main Street", "Second Street");
        
        String toString = direction.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("Direction"));
        assertTrue(toString.contains("Test Direction"));
        assertTrue(toString.contains("Main Street"));
        assertTrue(toString.contains("Second Street"));
    }
}