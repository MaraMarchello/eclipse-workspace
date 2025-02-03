package first;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void newLibraryShouldBeEmptyButNotNull() {
        List<String> books = library.getAllBooks();
        assertNotNull(books, "Books list should not be null");
        assertTrue(books.isEmpty(), "New library should be empty");
    }

    @Test
    void shouldMaintainCorrectOrderAfterInsertingMultipleBooks() {
        library.addBook("The Hobbit");
        library.addBook("Animal Farm");
        library.addBook("Dune");
        
        List<String> books = library.getAllBooks();
        assertEquals(3, books.size(), "Should have 3 books");
        assertEquals("Animal Farm", books.get(0), "First book should be Animal Farm");
        assertEquals("Dune", books.get(1), "Second book should be Dune");
        assertEquals("The Hobbit", books.get(2), "Third book should be The Hobbit");
    }

    @Test
    void shouldVerifyBookInCorrectPosition() {
        library.addBook("1984");
        library.addBook("Brave New World");
        
        assertEquals("1984", library.getBookByPosition(0), "1984 should be in position 0");
        assertEquals("Brave New World", library.getBookByPosition(1), "Brave New World should be in position 1");
    }

    @Test
    void shouldNotAllowDuplicateBooks() {
        library.addBook("The Great Gatsby");
        assertThrows(IllegalArgumentException.class, () -> {
            library.addBook("The Great Gatsby");
        }, "Should not allow duplicate books");
    }

    @Test
    void shouldRetrieveBookByPosition() {
        library.addBook("Lord of the Rings");
        library.addBook("Foundation");
        
        assertEquals("Foundation", library.getBookByPosition(0));
        assertEquals("Lord of the Rings", library.getBookByPosition(1));
    }

    @Test
    void shouldModifyListWhenAddingBook() {
        int initialSize = library.size();
        library.addBook("Fahrenheit 451");
        assertEquals(initialSize + 1, library.size(), "Size should increase by 1");
        assertTrue(library.containsBook("Fahrenheit 451"), "Should contain the added book");
    }

    @Test
    void shouldDecreaseSizeWhenRemovingBook() {
        library.addBook("The Catcher in the Rye");
        int initialSize = library.size();
        
        assertTrue(library.removeBook("The Catcher in the Rye"), "Should return true when removing existing book");
        assertEquals(initialSize - 1, library.size(), "Size should decrease by 1");
        assertFalse(library.containsBook("The Catcher in the Rye"), "Should not contain the removed book");
    }

    @Test
    void shouldMaintainAlphabeticalOrderAfterOperations() {
        library.addBook("C Book");
        library.addBook("A Book");
        library.addBook("B Book");
        
        List<String> books = library.getAllBooks();
        assertEquals("A Book", books.get(0));
        assertEquals("B Book", books.get(1));
        assertEquals("C Book", books.get(2));

        library.removeBook("B Book");
        books = library.getAllBooks();
        assertEquals("A Book", books.get(0));
        assertEquals("C Book", books.get(1));

        library.addBookAtPosition("B Book", 1);
        books = library.getAllBooks();
        assertEquals("A Book", books.get(0));
        assertEquals("B Book", books.get(1));
        assertEquals("C Book", books.get(2));
    }

    @Test
    void shouldThrowExceptionForInvalidPositions() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            library.getBookByPosition(-1);
        }, "Should throw exception for negative position");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            library.getBookByPosition(0);
        }, "Should throw exception for empty library");

        library.addBook("Test Book");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            library.getBookByPosition(1);
        }, "Should throw exception for position >= size");
    }
}
