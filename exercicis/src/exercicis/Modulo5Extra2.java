package exercicis;

import java.util.Scanner;

public class Modulo5Extra2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce la altura de la letra L: ");
		int altura = sc.nextInt();

		int longitudMastilHorizontal = (altura / 2) + 1;

		for (int i = 0; i < altura; i++) {

			if (i < altura - 1) {
				System.out.print("*");
			} else {

				for (int h = 0; h < longitudMastilHorizontal; h++) {
					System.out.print(" * ");
				}
			}

			System.out.println();
		}

		sc.close();
	}
}
