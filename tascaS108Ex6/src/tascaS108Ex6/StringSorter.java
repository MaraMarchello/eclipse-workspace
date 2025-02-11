package tascaS108Ex6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringSorter {
	public static void main(String[] args) {

		List<Object> mixedList = new ArrayList<>();
		mixedList.add("Hola");
		mixedList.add(42);
		mixedList.add("Barcelona");
		mixedList.add(7);
		mixedList.add("A");
		mixedList.add("Java");

		System.out.println("Lista original: " + mixedList);

		List<String> strings = mixedList.stream()
				.filter(item -> item instanceof String)
				.map(item -> (String) item)
				.sorted(Comparator.comparingInt(String::length))
				.toList();

		System.out.println("Cadenes ordenades per longitud (de més curta a més llarga): " + strings);

	}
}
