package tascaS108Ex2;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StringFilter2 {

	public static List<String> findLongStringsWithO(List<String> strings) {
		return strings.stream().filter(str -> str.toLowerCase().contains("o")).filter(str -> str.length() > 5)
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {

		List<String> words = Arrays.asList("Hello", "World", "Java", "Programming", "Code", "Computer");
		List<String> result = findLongStringsWithO(words);
		System.out.println("Strings containing 'O' with more than 5 letters: " + result);
	}
}