package exercicis;

import java.util.Scanner;

public class Modulo5Ex4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int randomNumber = (int) Math.ceil(Math.random() * 10);
		int userNumber = 0;
		int attemptsNumber = 5;
		int attemptsMade = 0;

		while (attemptsMade < attemptsNumber) {
			System.out.print("Adivina el número (entre 1 y 10): ");
			userNumber = sc.nextInt();
			attemptsMade++;

			if (userNumber < 1 || userNumber > 10) {
				System.out.println("Por favor, ingresa un número válido entre 1 y 10.");
				attemptsMade--;
			} else if (userNumber < randomNumber) {
				System.out.println("El número es mayor. Intenta de nuevo.");
			} else if (userNumber > randomNumber) {
				System.out.println("El número es menor. Intenta de nuevo.");
			} else {
				System.out.println("¡Enhorabuena, el número era " + randomNumber + " y has necesitado " + attemptsMade
						+ " intentos para acertarlo!");
				sc.close();
				return;
				
			}
		}

		System.out.println("¡Has utilizado demasiados intentos! El número era " + randomNumber + ".");
		sc.close();
	}
}