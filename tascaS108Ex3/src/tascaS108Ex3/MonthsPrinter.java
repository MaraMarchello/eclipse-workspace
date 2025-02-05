package tascaS108Ex3;

import java.util.List;
import java.util.Arrays;

public class MonthsPrinter {
	public static void main(String[] args) {
		List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");

		months.forEach(month -> System.out.println(month));

	}
}
