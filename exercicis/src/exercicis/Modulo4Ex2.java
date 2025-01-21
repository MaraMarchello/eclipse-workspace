package exercicis;

import java.util.Scanner;

public class Modulo4Ex2 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Por favor, introduce tu edad: ");
		int age = sc.nextInt();

		if (age <= 5) {
			System.out.println("Preescolar.");
		} else if (age <= 11) {
			System.out.println("Primaria.");
		} else if (age <= 15) {
			System.out.println("ESO.");
		} else if (age >= 16 && age <= 17) {
			System.out.println("Bachillerato.");
		} else {
			System.out.println("FP o Universidad.");
		}

		sc.close();
	}
}
