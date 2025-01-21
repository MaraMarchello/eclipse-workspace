package exercicis;

import java.util.Scanner;

public class Modulo5Ex3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int randomNumber = (int) Math.ceil(Math.random() * 10);
		int userNumber = 0;

		while (userNumber != randomNumber) {
			System.out.println("Adivina el número (entre 1 y 10): ");
			userNumber = sc.nextInt();

			if (userNumber < 1 || userNumber > 10) {
				System.out.println("Por favor, ingresa un número válido entre 1 y 10.");
			} else if (userNumber < randomNumber) {
				System.out.println("El número es mayor. Intenta de nuevo.");
			} else if (userNumber > randomNumber) {
				System.out.println("El número es menor. Intenta de nuevo.");
				}
			}

			System.out.println("¡Enhorabuena, el número era " + randomNumber + "!");

			sc.close();
		}
	}