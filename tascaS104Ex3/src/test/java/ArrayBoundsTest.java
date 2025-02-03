	import org.junit.jupiter.api.Test;
	import static org.junit.jupiter.api.Assertions.*;

	public class ArrayBoundsTest {
	    private final ArrayBounds demo = new ArrayBounds();

	    @Test
	    void testValidArrayAccess() {
	        
	        assertEquals(1, demo.getElementAtIndex(0));
	        assertEquals(5, demo.getElementAtIndex(4));
	    }

	    @Test
	    void testArrayIndexOutOfBoundsException() {
	        
	        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
	            demo.getElementAtIndex(-1);
	        });

	        
	        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
	            demo.getElementAtIndex(5);
	        });
	    }
	}

