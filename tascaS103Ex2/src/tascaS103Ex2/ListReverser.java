package tascaS103Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListReverser {
	public static void main(String[] args) {
		List<Integer> firstList = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			firstList.add(i);
		}

		List<Integer> secondList = new ArrayList<>();

		ListIterator<Integer> iterator = firstList.listIterator(firstList.size());

		while (iterator.hasPrevious()) {
			secondList.add(iterator.previous());
		}

		System.out.println("First List (original order):");
		System.out.println(firstList);

		System.out.println("\nSecond List (reverse order):");
		System.out.println(secondList);
	}
}
