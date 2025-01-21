package exercicis;

import java.util.*;

public class Modulo7Ex25 {

	public static void main(String[] args) {

		ArrayList<String> original = new ArrayList<>();
		original.add("Anna");
		original.add("Bruna");
		original.add("Clara");
		original.add("Diana");
		original.add("Elena");

		ArrayList<String> inverted = new ArrayList<>();

		for (int i = original.size() - 1; i >= 0; i--) {
			inverted.add(original.get(i));
		}

		//System.out.println("ArrayList original: " + original);
		System.out.println("ArrayList en orden inverso: " + inverted);
	}
}