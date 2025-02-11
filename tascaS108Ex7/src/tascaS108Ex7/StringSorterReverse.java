package tascaS108Ex7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringSorterReverse {

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
				.collect(Collectors.toList());

		
		strings.sort(Comparator.comparingInt(String::length).reversed());
		
		System.out.println("Cadenes ordenades per longitud (de més llarga a més curta): " + strings);

	}

}
