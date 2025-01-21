package exercicis;

import java.util.Scanner;

public class Modulo7Ex32 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce una palabra: ");
		String input = sc.nextLine();

		String stringInvertido = "";

		for (int i = input.length() - 1; i >= 0; i--) {
			stringInvertido += input.charAt(i);
		}

		System.out.println("La palabra al revés es: " + stringInvertido);

		sc.close();
	}
}
