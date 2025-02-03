package tascaS103Ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Month {
	private String name;

	public Month(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Month month = (Month) obj;
		return name.equals(month.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		ArrayList<Month> monthList = new ArrayList<>();
		monthList.add(new Month("January"));
		monthList.add(new Month("February"));
		monthList.add(new Month("March"));
		monthList.add(new Month("April"));
		monthList.add(new Month("May"));
		monthList.add(new Month("June"));
		monthList.add(new Month("July"));
		monthList.add(new Month("September"));
		monthList.add(new Month("October"));
		monthList.add(new Month("November"));
		monthList.add(new Month("December"));
		monthList.add(7, new Month("August"));

		System.out.println("ArrayList contents:");
		for (Month month : monthList) {
			System.out.println(month);
		}

		HashSet<Month> monthSet = new HashSet<>(monthList);

		monthSet.add(new Month("January"));

		System.out.println("\nHashSet contents using for-each loop:");
		for (Month month : monthSet) {
			System.out.println(month);
		}

		System.out.println("\nHashSet contents using iterator:");
		Iterator<Month> iterator = monthSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
