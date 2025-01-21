package exercicis;

import java.util.*;

public class Modulo7Ex33 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca la frase:");
		String input = sc.nextLine();

		String normalizedInput = input.replaceAll("\\s+", "").toLowerCase();

		if (isPalindrome(normalizedInput)) {
			System.out.println("La frase es un palíndromo.");
		} else {
			System.out.println("La frase no es un palíndromo.");
		}

		sc.close();
	}

	public static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
