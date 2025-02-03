import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoGenericMethodsTest {

	@Test
	void testConstructorWithDifferentArgumentOrder() {

		NoGenericMethods obj1 = new NoGenericMethods(1, 2, 3);
		NoGenericMethods obj2 = new NoGenericMethods(3, 1, 2);
		NoGenericMethods obj3 = new NoGenericMethods(2, 3, 1);

		assertNotNull(obj1);
		assertNotNull(obj2);
		assertNotNull(obj3);
	}

	@Test
	void testGettersAndSetters() {
		NoGenericMethods obj = new NoGenericMethods("A", "B", "C");

		assertEquals("A", obj.getArg1());
		assertEquals("B", obj.getArg2());
		assertEquals("C", obj.getArg3());

		// Test setters
		obj.setArg1("X");
		obj.setArg2("Y");
		obj.setArg3("Z");

		assertEquals("X", obj.getArg1());
		assertEquals("Y", obj.getArg2());
		assertEquals("Z", obj.getArg3());
	}

	@Test
	void testDifferentTypes() {

		NoGenericMethods stringObj = new NoGenericMethods("1", "2", "3");
		NoGenericMethods intObj = new NoGenericMethods(1, 2, 3);
		NoGenericMethods doubleObj = new NoGenericMethods(1.0, 2.0, 3.0);

		assertNotNull(stringObj);
		assertNotNull(intObj);
		assertNotNull(doubleObj);
	}

	@Test
	void testMixedTypesThrowsException() {

		assertThrows(IllegalArgumentException.class, () -> {
			new NoGenericMethods("1", 2, 3.0);
		});

		NoGenericMethods obj = new NoGenericMethods("A", "B", "C");
		assertThrows(IllegalArgumentException.class, () -> {
			obj.setArg1(1);
		});
	}
}
