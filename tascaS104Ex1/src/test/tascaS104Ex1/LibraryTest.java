package tascaS104Ex1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testNewLibraryIsEmpty() {
        assertNotNull(library.getAllBooks());
        assertTrue(library.getAllBooks().isEmpty());
    }

    @Test
    void testAddMultipleBooks() {
        library.addBook("The Hobbit");
        library.addBook("1984");
        library.addBook("Dune");
        
        assertEquals(3, library.getAllBooks().size());
        assertEquals("1984", library.getAllBooks().get(0));
        assertEquals("Dune", library.getAllBooks().get(1));
        assertEquals("The Hobbit", library.getAllBooks().get(2));
    }

    @Test
    void testBookInCorrectPosition() {
        library.addBook("The Hobbit");
        library.addBook("1984");
        library.addBookAtPosition("Dune", 1);
        
        assertEquals("Dune", library.getBookByPosition(1));
    }

    @Test
    void testNoDuplicateBooks() {
        library.addBook("The Hobbit");
        library.addBook("The Hobbit");
        
        assertEquals(1, library.size());
    }

    @Test
    void testGetBookByPosition() {
        library.addBook("The Hobbit");
        library.addBook("1984");
        
        assertEquals("1984", library.getBookByPosition(0));
        assertEquals("The Hobbit", library.getBookByPosition(1));
    }

    @Test
    void testAddBookModifiesList() {
        library.addBook("The Hobbit");
        int initialSize = library.size();
        
        library.addBook("1984");
        assertEquals(initialSize + 1, library.size());
    }

    @Test
    void testRemoveBookDecreasesSize() {
        library.addBook("The Hobbit");
        library.addBook("1984");
        int initialSize = library.size();
        
        library.removeBook("The Hobbit");
        assertEquals(initialSize - 1, library.size());
    }

    @Test
    void testListRemainsAlphabeticallySorted() {
        library.addBook("The Hobbit");
        library.addBook("1984");
        library.addBook("Dune");
        library.addBook("Brave New World");
        
        var books = library.getAllBooks();
        assertEquals("1984", books.get(0));
        assertEquals("Brave New World", books.get(1));
        assertEquals("Dune", books.get(2));
        assertEquals("The Hobbit", books.get(3));
    }

    @Test
    void testInvalidPositionThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            library.getBookByPosition(-1);
        });
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            library.getBookByPosition(0);
        });
    }
} 