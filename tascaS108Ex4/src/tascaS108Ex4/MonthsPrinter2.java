package tascaS108Ex4;

import java.util.List;
import java.util.Arrays;

public class MonthsPrinter2 {
	public static void main(String[] args) {
		List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");

		months.forEach(System.out::println);

	}
}
