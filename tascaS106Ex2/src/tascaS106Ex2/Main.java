package tascaS106Ex2;

public class Main {
	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		Person person = new Person("John", "Doe", 30);

		// Test 1: Person, String, Integer
		System.out.println("Test 1 - Person, String, Integer:");
		gm.printThreeArguments(person, "Hello World", 42);

		// Test 2: Integer, Person, String
		System.out.println("\nTest 2 - Integer, Person, String:");
		gm.printThreeArguments(100, person, "Testing");

		// Test 3: String, Double, Person
		System.out.println("\nTest 3 - String, Double, Person:");
		gm.printThreeArguments("Java Generics", 3.14, person);

		// Test 4: Different primitive wrapper types
		System.out.println("\nTest 4 - Different primitive wrapper types:");
		gm.printThreeArguments(42, 3.14159, true);

		// Test 5: All same type (Strings)
		System.out.println("\nTest 5 - All Strings:");
		gm.printThreeArguments("First", "Second", "Third");
	}
}
