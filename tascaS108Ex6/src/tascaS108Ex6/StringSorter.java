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


		List<String> strings = new ArrayList<>();
		for (Object item : mixedList) {
			if (item instanceof String) {
				strings.add((String) item);
			}
		}


		strings.sort(Comparator.comparingInt(String::length));

		System.out.println("Cadenes ordenades per longitud (de més curta a més llarga): " + strings);

	}
}
