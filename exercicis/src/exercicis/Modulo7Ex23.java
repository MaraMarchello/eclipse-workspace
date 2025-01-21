package exercicis;

import java.util.Scanner;

public class Modulo7Ex23 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca un número: ");
		int count = sc.nextInt();

		if (count > 0) {
			for (int i = count; i > 0; i--) {

				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("El número debe ser positivo.");
		}

		sc.close();
	}
}
